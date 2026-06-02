package shop;


public class Shop {
    java.util.List<Instrument> instruments;
    public void add(Instrument i) {
        if (instruments == null) {
            instruments = new java.util.ArrayList<>();
        }
        instruments.add(i);
    }

    public Instrument get (int serial) {
        for (Instrument i : instruments) {
            if (i.getSerial() == serial) {
                return i;
            }
        }
        return null;
    }

    public java.util.List<Integer> allSerials() {
        java.util.List<Integer> serials = new java.util.ArrayList<>();
        for (Instrument i : instruments) {
            serials.add(i.getSerial());
        }
        return serials;
    }

    public java.util.List<Integer> guitarsOfType(Type type) {
        java.util.List<Integer> serials = new java.util.ArrayList<>();
        for (Instrument i : instruments) {
            if (i instanceof Guitar && ((Guitar) i).getType() == type) {
                serials.add(i.getSerial());
            }
        }
        return serials;
    }

    public void sell(int serial) throws MusicShopException {
        for (int i = 0; i < instruments.size(); i++) {
            if (instruments.get(i).getSerial() == serial) {
                Guitar g = null;
                if (instruments.get(i) instanceof Guitar) {
                    g = (Guitar) instruments.get(i);
                    int guitarCount = 0;
                    for (Instrument j : instruments) {
                        if (j instanceof Guitar) guitarCount++;
                    }
                    if (guitarCount == 1) {
                        throw new MusicShopException("Cannot sell the last guitar in the shop.");
                    }
                }
                System.out.println("Selling " + instruments.get(i));
                instruments.remove(i);
                return;
            }
        }
        throw new MusicShopException("Instrument with serial " + serial + " not found.");
    }

    public int sellAll(int[] serials) {
        int notSell = 0;
        for (int serial : serials) {
            try {
                sell(serial);
            } catch (MusicShopException e) {
                System.out.println(e.getMessage());
                notSell++;
            }
        }
        return notSell;
    }
}
