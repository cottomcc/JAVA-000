package cc.cottom.proxy.apo;

import cc.cottom.proxy.bean.DBContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class DataSourceAOP {

    @Before("execution(* cc.cottom.proxy.mapper..*.find*(..)) "
            + " or execution(* cc.cottom.proxy.mapper..*.get*(..)) "
            + " or execution(* cc.cottom.proxy.mapper..*.query*(..))")
    public void setReadDataSourceType() {
        DBContextHolder.setSlave();
    }

    @Before("execution(* cc.cottom.proxy.mapper..*.insert*(..)) "
            + " or execution(* cc.cottom.proxy.mapper..*.delete*(..)) "
            + " or execution(* cc.cottom.proxy.mapper..*.update*(..))"
            + " or execution(* cc.cottom.proxy.mapper..*.add*(..))")
    public void setWriteDataSourceType() {
        log.info("set write data source");
        DBContextHolder.setMaster();
    }
}
