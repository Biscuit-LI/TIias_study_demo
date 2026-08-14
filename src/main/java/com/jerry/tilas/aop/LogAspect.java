package com.jerry.tilas.aop;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.jerry.tilas.mapper.LogMapper;
import com.jerry.tilas.pojo.OperateLog;
import com.jerry.tilas.util.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Map;

@Slf4j
@Aspect
@Component
@Order(3)
public class LogAspect {

    @Autowired
    private LogMapper logMapper;

    private final ObjectMapper objectMapper = new ObjectMapper();

    //记录操作日志->数据库（operate_log）
    @Around("@annotation(com.jerry.tilas.anno.LogOperation)")
    public Object logWrite(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();

        // 执行原始方法
        Object result = pjp.proceed();

        long costTime = System.currentTimeMillis() - start;

        // 构建日志记录
        OperateLog operateLog = new OperateLog();
        operateLog.setOperateEmpId(getCurrentEmpId());
        operateLog.setOperateTime(LocalDateTime.now());
        operateLog.setClassName(pjp.getTarget().getClass().getName());
        operateLog.setMethodName(pjp.getSignature().getName());
        operateLog.setMethodParams(Arrays.toString(pjp.getArgs()));
        operateLog.setCostTime(costTime);

        try {
            operateLog.setReturnValue(objectMapper.writeValueAsString(result));
        } catch (Exception e) {
            operateLog.setReturnValue("序列化失败");
        }

        // 保存到数据库
        logMapper.insert(operateLog);

        return result;
    }

    private Integer getCurrentEmpId() {
        try {
            ServletRequestAttributes attributes =
                    (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (attributes == null) {
                return null;
            }
            HttpServletRequest request = attributes.getRequest();
            String token = request.getHeader("token");
            if (token == null || token.isEmpty()) {
                return null;
            }
            Map<String, Object> claims = JwtUtils.parseToken(token);
            Object id = claims.get("id");
            if (id instanceof Number) {
                return ((Number) id).intValue();
            }
            return null;
        } catch (Exception e) {
            log.warn("获取当前登录用户失败: {}", e.getMessage());
            return null;
        }
    }
}
