enum Coin {
    PENNY(1), NICKEL(5), DIME(10), QUARTER(25);

    private final int cents;

    Coin(int cents) {
        this.cents = cents;
    }

    int cents() {
        return cents;
    }
}

void main() {
    String[] names = IO.readln().trim().split(" +");

    Map<Coin, Integer> counts = new EnumMap<>(Coin.class);

    for (String name : names) {
        if (name.isEmpty())
            continue; // linha vazia

        Coin coin = null;
        for (Coin c : Coin.values()) {
            if (c.name().equalsIgnoreCase(name)) {
                coin = c;
                break;
            }
        }

        if (coin == null) {
            IO.println("Unknown coin: " + name);
        } else {
            counts.merge(coin, 1, Integer::sum);
        }
    }

    int total = 0;
    for (Map.Entry<Coin, Integer> e : counts.entrySet()) {
        IO.println(e.getKey().name() + " x" + e.getValue());
        total += e.getKey().cents() * e.getValue();
    }

    IO.println("Total: " + total + " cents");
}