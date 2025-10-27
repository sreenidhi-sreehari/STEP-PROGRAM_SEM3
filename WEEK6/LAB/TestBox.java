class Box {
    String pack() {
        return "Packing the box";
    }

    String unpack() {
        return "Unpacking the box";
    }
}

class GiftBox extends Box {
    @Override
    String pack() {
        return super.pack() + ", adding gift wrap";
    }

    @Override
    String unpack() {
        return super.unpack() + ", removing gift wrap";
    }
}

public class TestBox {
    public static void main(String[] args) {
        Box box = new Box();
        GiftBox giftBox = new GiftBox();

        System.out.println(box.pack());
        System.out.println(box.unpack());
        System.out.println(giftBox.pack());
        System.out.println(giftBox.unpack());
    }
}
