package io.zatec.zatectest.shared;

import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest public abstract class AbstractSharedTest {

    public static MockWebServer mockWebServer;

    @BeforeAll static void setUp() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
    }

    @AfterAll static void tearDown() throws IOException {
        mockWebServer.shutdown();
    }
}
