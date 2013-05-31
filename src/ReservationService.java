public class ReservationService {
    private ReservationRepository repository;
     
    public ReservationService(ReservationRepository repository) {
        this.repository = repository;
    }
     
    public Confirmation reserve(Room room) {
        // some logic using our repository
        return new Confirmation();
    }
}