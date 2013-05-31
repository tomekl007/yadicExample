package decorator;

import javax.xml.ws.Response;
import java.util.Date;

import static com.googlecode.totallylazy.Pair.pair;

public class AuditHandler implements HttpHandler {
 
    private final HttpHandler delegate;
    private final Auditor auditor;
 
    public AuditHandler(HttpHandler delegate, Auditor auditor) {
        this.delegate = delegate;
        this.auditor = auditor;
    }
 
    public Response handle(Request request) throws Exception {
        Date requestDate = new Date();
 
        Response response = delegate.handle(request);
 
        Date responseDate = new Date();
 
        try {
            auditor.audit(pair(request, requestDate), pair(response, responseDate));
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return response;
 
    }
}