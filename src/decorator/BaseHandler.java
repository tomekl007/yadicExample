package decorator;

import javax.xml.ws.Response;

public class BaseHandler implements HttpHandler {
    @Override
    public Response handle(Request request) throws Exception {
        return  null;

    }
    // basic HTTP handling functionality
}