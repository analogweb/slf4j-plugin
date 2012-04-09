package org.analogweb.util.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MarkerFactory;

/**
 * <a href="http://www.slf4j.org/">SLF4j</a>を使用した{@link AbstractLog}の実装です。<br/>
 * ログ出力の設定、及び解決は、全てSLF4jに委譲されます。
 * @author snowgoose
 */
public class LogImpl extends AbstractLog {

    private Logger log;

    /**
     * コンストラクタ。
     * @param name 生成されるロガーの名称({@link LoggerFactory#getLogger(String)})
     * @param classLoader {@link ClassLoader}
     */
    public LogImpl(String name, ClassLoader classLoader) {
        super(name, classLoader);
        log = LoggerFactory.getLogger(name);
    }

    @Override
    public void trace(String message, Object... args) {
        log.trace(message, (Object[]) args);
    }

    @Override
    public void trace(String message, Throwable throwable) {
        log.trace(message, throwable);
    }

    @Override
    public void trace(Marker marker, String message) {
        log.trace(toMarker(marker), message);
    }

    @Override
    public void trace(Marker marker, String message, Object... args) {
        log.trace(toMarker(marker), message, (Object[]) args);
    }

    @Override
    public void trace(Marker marker, String message, Throwable throwable) {
        log.trace(toMarker(marker), message, throwable);
    }

    @Override
    public boolean isTraceEnabled() {
        return log.isTraceEnabled();
    }

    @Override
    public boolean isTraceEnabled(Marker marker) {
        return log.isTraceEnabled(toMarker(marker));
    }

    @Override
    public void debug(String message, Throwable throwable) {
        log.debug(message, throwable);
    }

    @Override
    public void debug(String message, Object... args) {
        log.debug(message, (Object[]) args);
    }

    @Override
    public void debug(Marker marker, String message) {
        log.debug(toMarker(marker), message);
    }

    @Override
    public void debug(Marker marker, String message, Throwable throwable) {
        log.debug(toMarker(marker), message, throwable);
    }

    @Override
    public void debug(Marker marker, String message, Object... args) {
        log.debug(toMarker(marker), message, (Object[]) args);
    }

    @Override
    public boolean isDebugEnabled() {
        return log.isDebugEnabled();
    }

    @Override
    public boolean isDebugEnabled(Marker marker) {
        return log.isDebugEnabled(toMarker(marker));
    }

    @Override
    public void info(String message, Throwable throwable) {
        log.info(message, throwable);
    }

    @Override
    public void info(String message, Object... args) {
        log.info(message, (Object[]) args);
    }

    @Override
    public void info(Marker marker, String message) {
        log.info(toMarker(marker), message);
    }

    @Override
    public void info(Marker marker, String message, Throwable throwable) {
        log.info(toMarker(marker), message, throwable);
    }

    @Override
    public void info(Marker marker, String message, Object... args) {
        log.info(toMarker(marker), message, (Object[]) args);
    }

    @Override
    public boolean isInfoEnabled() {
        return log.isInfoEnabled();
    }

    @Override
    public boolean isInfoEnabled(Marker marker) {
        return log.isInfoEnabled(toMarker(marker));
    }

    @Override
    public void warn(String message, Throwable throwable) {
        log.warn(message, throwable);
    }

    @Override
    public void warn(String message, Object... args) {
        log.warn(message, (Object[]) args);
    }

    @Override
    public void warn(Marker marker, String message) {
        log.warn(toMarker(marker), message);
    }

    @Override
    public void warn(Marker marker, String message, Throwable throwable) {
        log.warn(toMarker(marker), message, throwable);
    }

    @Override
    public void warn(Marker marker, String message, Object... args) {
        log.warn(toMarker(marker), message, (Object[]) args);
    }

    @Override
    public boolean isWarnEnabled() {
        return log.isWarnEnabled();
    }

    @Override
    public boolean isWarnEnabled(Marker marker) {
        return log.isWarnEnabled(toMarker(marker));
    }

    @Override
    public void error(String message, Throwable throwable) {
        log.error(message, throwable);
    }

    @Override
    public void error(String message, Object... args) {
        log.error(message, (Object[]) args);
    }

    @Override
    public void error(Marker marker, String message) {
        log.error(toMarker(marker), message);
    }

    @Override
    public void error(Marker marker, String message, Throwable throwable) {
        log.error(toMarker(marker), message, throwable);
    }

    @Override
    public void error(Marker marker, String message, Object... args) {
        log.error(toMarker(marker), message, (Object[]) args);
    }

    @Override
    public boolean isErrorEnabled() {
        return log.isErrorEnabled();
    }

    @Override
    public boolean isErrorEnabled(Marker marker) {
        return log.isErrorEnabled(toMarker(marker));
    }

    /**
     * {@link org.analogweb.util.logging.Marker}を
     * {@link org.slf4j.Marker}に変換します。<br/>
     * {@link org.analogweb.util.logging.Marker#getName()}
     * の値から、{@link MarkerFactory#getMarker(String)}によって
     * 生成されます。
     * @param marker {@link org.analogweb.util.logging.Marker}
     * @return {@link org.slf4j.Marker}
     */
    protected org.slf4j.Marker toMarker(Marker marker) {
        return MarkerFactory.getMarker(marker.getName());
    }

    @Override
    public String toString(){
        return "Logger Facade for org.slf4j.Logger";
    }
}
