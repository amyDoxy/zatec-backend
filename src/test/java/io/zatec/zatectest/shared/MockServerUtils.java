package io.zatec.zatectest.shared;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;

import java.net.URI;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

/**
 * MockServer Expectations methods to be shared across test classes.
 *
 * @author amy.muhimpundu
 */
public class MockServerUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Generic method to create a GET expectation matching URL pattern
     *
     * @param mockWebServer    {@link MockWebServer}
     * @param url              the GET API URL
     * @param expectedCount    how many times we expect the API to be called
     * @param expectedResponse the expect response
     * @throws Exception
     */
    public static void createGETExpectationWithPatternURL(MockWebServer mockWebServer, String url, ExpectedCount expectedCount,
            Object expectedResponse) throws Exception {
        createExpectationWithPatternURL(mockWebServer, url, expectedCount, expectedResponse, HttpMethod.GET);
    }

    /**
     * Generic method to create a expectation matching URL pattern
     *
     * @param mockWebServer    {@link MockWebServer}
     * @param url              the GET API URL
     * @param expectedCount    how many times we expect the API to be called
     * @param expectedResponse the expect response
     * @throws Exception
     */
    public static void createExpectationWithPatternURL(MockWebServer mockWebServer, String url, ExpectedCount expectedCount,
            Object expectedResponse, HttpMethod httpMethod) throws Exception {
        //        mockServer.expect(expectedCount, requestTo(matchesPattern(url))).andExpect(method(httpMethod)).andRespond(
        //                withStatus(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(objectMapper.writeValueAsString(expectedResponse)));
        mockWebServer.enqueue(new MockResponse().setBody(objectMapper.writeValueAsString(expectedResponse))
                .setStatus(String.valueOf(HttpStatus.OK.value())).addHeader("Content-Type", "application/json"));
    }

    /**
     * Generic method to create a GET expectation
     *
     * @param mockServer       {@link MockRestServiceServer}
     * @param url              the GET API URL
     * @param expectedCount    how many times we expect the API to be called
     * @param expectedResponse the expect response
     * @throws Exception
     */
    public static void createGETExpectation(MockRestServiceServer mockServer, String url, ExpectedCount expectedCount,
            Object expectedResponse) throws Exception {
        mockServer.expect(expectedCount, requestTo(new URI(url))).andExpect(method(HttpMethod.GET)).andRespond(
                withStatus(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(objectMapper.writeValueAsString(expectedResponse)));
    }

    /**
     * Generic method to create a POST expectation
     *
     * @param mockServer       {@link MockRestServiceServer}
     * @param url              the GET API URL
     * @param expectedCount    how many times we expect the API to be called
     * @param expectedResponse the expect response
     * @throws Exception
     */
    public static void createPOSTExpectation(MockRestServiceServer mockServer, String url, ExpectedCount expectedCount,
            Object expectedResponse) throws Exception {
        mockServer.expect(expectedCount, requestTo(new URI(url))).andExpect(method(HttpMethod.POST))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andRespond(
                        withStatus(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(objectMapper.writeValueAsString(expectedResponse)));
    }

    public static void createExceptionExpectation(MockRestServiceServer mockServer, String url, ExpectedCount expectedCount,
            HttpMethod httpMethod, HttpStatus status) throws Exception {

        mockServer.expect(expectedCount, requestTo(new URI(url))).andExpect(method(httpMethod)).andRespond(withStatus(status));
    }
}