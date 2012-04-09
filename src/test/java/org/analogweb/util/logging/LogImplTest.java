package org.analogweb.util.logging;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.analogweb.util.logging.Markers.SimpleMarker;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.AppenderBase;

public class LogImplTest {

    private Log log;
    private StubAppender mockAppender;

    @Before
    public void setUp() throws Exception {
        resetLog(Level.ALL);
    }

    @SuppressWarnings("unchecked")
    public void resetLog(Level level) {
        log = Logs.getLog(LogImplTest.class);
        Logger root = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        mockAppender = new StubAppender();
        root.addAppender(mockAppender);
        root.setLevel(level);
    }

    @Test
    public void testTraceLog() {
        Level level = Level.TRACE;
        String message = "analog log message.";
        Throwable expectedException = new IOException();
        Marker marker = SimpleMarker.valueOf("Marked");

        log.trace(message);
        verifyLog(level, message);
        log.trace(message, expectedException);
        verifyLog(level, message);
        log.trace(marker, message);
        verifyLog(level, marker, message);

        message = "analog {} message.";
        log.trace(marker, message, "log");
        verifyLog(level, marker, "analog log message.");

        message = "analog log message.";
        log.trace(marker, message, expectedException);
        verifyLog(level, marker, message);

        assertThat(log.isTraceEnabled(), is(true));
        assertThat(log.isTraceEnabled(SimpleMarker.valueOf("ROOT")), is(true));
        resetLog(Level.DEBUG);
        assertThat(log.isTraceEnabled(), is(false));
        assertThat(log.isTraceEnabled(SimpleMarker.valueOf("ROOT")), is(false));
    }

    @Test
    public void testDebugLog() {
        Level level = Level.DEBUG;
        String message = "analog log message.";
        Throwable expectedException = new IOException();
        Marker marker = SimpleMarker.valueOf("Marked");

        log.debug(message);
        verifyLog(level, message);
        log.debug(message, expectedException);
        verifyLog(level, message);
        log.debug(marker, message);
        verifyLog(level, marker, message);

        message = "analog {} message.";
        log.debug(marker, message, "log");
        verifyLog(level, marker, "analog log message.");

        message = "analog log message.";
        log.debug(marker, message, expectedException);
        verifyLog(level, marker, message);

        assertThat(log.isDebugEnabled(), is(true));
        assertThat(log.isDebugEnabled(SimpleMarker.valueOf("ROOT")), is(true));
        resetLog(Level.INFO);
        assertThat(log.isDebugEnabled(), is(false));
        assertThat(log.isDebugEnabled(SimpleMarker.valueOf("ROOT")), is(false));
    }

    @Test
    public void testInfoLog() {
        Level level = Level.INFO;
        String message = "analog log message.";
        Throwable expectedException = new IOException();
        Marker marker = SimpleMarker.valueOf("Marked");

        log.info(message);
        verifyLog(level, message);
        log.info(message, expectedException);
        verifyLog(level, message);
        log.info(marker, message);
        verifyLog(level, marker, message);

        message = "analog {} message.";
        log.info(marker, message, "log");
        verifyLog(level, marker, "analog log message.");

        message = "analog log message.";
        log.info(marker, message, expectedException);
        verifyLog(level, marker, message);

        assertThat(log.isInfoEnabled(), is(true));
        assertThat(log.isInfoEnabled(SimpleMarker.valueOf("ROOT")), is(true));
        resetLog(Level.WARN);
        assertThat(log.isInfoEnabled(), is(false));
        assertThat(log.isInfoEnabled(SimpleMarker.valueOf("ROOT")), is(false));
    }

    @Test
    public void testWarnLog() {
        Level level = Level.WARN;
        String message = "analog log message.";
        Throwable expectedException = new IOException();
        Marker marker = SimpleMarker.valueOf("Marked");

        log.warn(message);
        verifyLog(level, message);
        log.warn(message, expectedException);
        verifyLog(level, message);
        log.warn(marker, message);
        verifyLog(level, marker, message);

        message = "analog {} message.";
        log.warn(marker, message, "log");
        verifyLog(level, marker, "analog log message.");

        message = "analog log message.";
        log.warn(marker, message, expectedException);
        verifyLog(level, marker, message);

        assertThat(log.isWarnEnabled(), is(true));
        assertThat(log.isWarnEnabled(SimpleMarker.valueOf("ROOT")), is(true));
        resetLog(Level.ERROR);
        assertThat(log.isWarnEnabled(), is(false));
        assertThat(log.isWarnEnabled(SimpleMarker.valueOf("ROOT")), is(false));
    }

    @Test
    public void testErrorLog() {
        Level level = Level.ERROR;
        String message = "analog log message.";
        Throwable expectedException = new IOException();
        Marker marker = SimpleMarker.valueOf("Marked");

        log.error(message);
        verifyLog(level, message);
        log.error(message, expectedException);
        verifyLog(level, message);
        log.error(marker, message);
        verifyLog(level, marker, message);

        message = "analog {} message.";
        log.error(marker, message, "log");
        verifyLog(level, marker, "analog log message.");

        message = "analog log message.";
        log.error(marker, message, expectedException);
        verifyLog(level, marker, message);

        assertThat(log.isErrorEnabled(), is(true));
        assertThat(log.isErrorEnabled(SimpleMarker.valueOf("ROOT")), is(true));
        resetLog(Level.OFF);
        assertThat(log.isErrorEnabled(), is(false));
        assertThat(log.isErrorEnabled(SimpleMarker.valueOf("ROOT")), is(false));

        System.out.println(log.toString());
    }

    private void verifyLog(final Level level, final Marker marker, final String message) {
        LoggingEvent event = mockAppender.latest();
        assertThat(event.getLevel(), is(level));
        assertThat(event.getMarker().getName(), is(marker.getName()));
        assertThat(event.getFormattedMessage(), is(message));
    }

    private void verifyLog(final Level level, final String message) {
        LoggingEvent event = mockAppender.latest();
        assertThat(event.getLevel(), is(level));
        assertThat(event.getFormattedMessage(), is(message));
    }

    @SuppressWarnings("rawtypes")
    private static class StubAppender extends AppenderBase {

        private LoggingEvent event;

        @Override
        public synchronized void doAppend(Object eventObject) {
            this.event = (LoggingEvent) eventObject;
        }

        LoggingEvent latest() {
            return this.event;
        }

        @Override
        protected void append(Object eventObject) {
            // nop.
        }

    }
}
