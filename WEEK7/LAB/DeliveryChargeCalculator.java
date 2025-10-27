class DeliveryChargeCalculator {

    // Basic delivery
    public void calculateCharge(double distance) {
        double basicCost = distance * 2; // Assuming a simple rate
        System.out.println("Basic delivery charge: $" + String.format("%.2f", basicCost));
    }

    // Premium delivery
    public void calculateCharge(double distance, double priorityFee) {
        double premiumCost = (distance * 2) + priorityFee;
        System.out.println("Premium delivery charge: $" + String.format("%.2f", premiumCost) + " (includes a $" + priorityFee + " priority fee).");
    }

    // Group delivery
    public void calculateCharge(double distance, int numberOfOrders, boolean isGroup) {
        double groupDiscount = (numberOfOrders > 5) ? 0.15 : 0.05; // 15% discount for more than 5 orders, otherwise 5%
        double groupCost = (distance * 2) * (1 - groupDiscount);
        System.out.println("Group delivery charge: $" + String.format("%.2f", groupCost) + " (includes a " + (groupDiscount * 100) + "% discount for a group order).");
    }

    // Festival special
    public void calculateCharge(double distance, double discountPercentage, double freeDeliveryThreshold) {
        double festivalCost = (distance * 2) * (1 - discountPercentage);
        if (festivalCost > freeDeliveryThreshold) {
            System.out.println("Festival delivery charge: $" + String.format("%.2f", festivalCost) + " (discount of " + (discountPercentage * 100) + "%)");
        } else {
            System.out.println("Festival special: Free delivery! (Order amount below $" + freeDeliveryThreshold + ").");
        }
    }

    public static void main(String[] args) {
        DeliveryChargeCalculator calculator = new DeliveryChargeCalculator();
        calculator.calculateCharge(5.5);
        calculator.calculateCharge(5.5, 3.0);
        calculator.calculateCharge(5.5, 7, true);
        calculator.calculateCharge(5.5, 0.25, 10.0);
    }
}