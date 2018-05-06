package listviewtest.example.com.listviewtest;

/**
 * Created by lifeng on 2017/3/25.
 */

public class FruitModel {
    private String name;

    private int imageId;

    public FruitModel(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
