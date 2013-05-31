package decorator;

import javax.xml.ws.Response;

public interface HttpHandler {
    Response handle(final Request request) throws Exception;
}