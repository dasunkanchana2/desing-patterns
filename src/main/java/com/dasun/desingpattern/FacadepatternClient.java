package com.dasun.desingpattern;

/**
 * The FacadepatternClient - Facade Pattern
 */
public class FacadepatternClient {
    public static void main(String[] args) {

       ShopKeeper shopKeeper  = new ShopKeeper();
       shopKeeper.iphoneSale();
       shopKeeper.samsungSale();
    }
}

interface MobileShop{

    void modelNo();
    void price();
}

class IPhone implements MobileShop{

    @Override
    public void modelNo() {
        System.out.println("Iphone 7");
    }

    @Override
    public void price() {
        System.out.println("95000");
    }
}

class Samsung implements MobileShop{
    @Override
    public void modelNo() {
        System.out.println("Galaxy");
    }

    @Override
    public void price() {
        System.out.println("25000");
    }
}

class ShopKeeper{

    private MobileShop iPhone;
    private MobileShop samsung;

    public ShopKeeper(){
        this.iPhone = new IPhone();
        this.samsung = new Samsung();
    }

    public void iphoneSale(){
        iPhone.modelNo();
        iPhone.price();
    }

    public void samsungSale(){
        samsung.modelNo();
        samsung.price();
    }

}
