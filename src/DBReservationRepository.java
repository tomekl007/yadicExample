public class DBReservationRepository implements ReservationRepository {

    public Confirmation reserve(Room room) {
        System.out.println("reserve Room ");
       return new Confirmation();
    }
}