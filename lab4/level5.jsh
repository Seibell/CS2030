void findBestBooking(Request request, List<Driver> drivers) {

    ImList<Booking> bookings = new ImList<Booking>();

    for (Driver d : drivers) {
        if (d.getCarType().equals("NormalCab")) {
            bookings = bookings.add(new Booking(d, request));
            bookings = bookings.add(new OtherBooking(d, request));
        }

        if (d.getCarType().equals("PrivateCar")) {
            bookings = bookings.add(new Booking(d, request));
            bookings = bookings.add(new OtherBooking(d, request));
        }
    }

    for (Booking b : bookings) {

        CompareBooking cmp = new CompareBooking();

        bookings = bookings.sort(cmp);
    }

    for (Booking b : bookings) {
        System.out.println(b);
    }
}
