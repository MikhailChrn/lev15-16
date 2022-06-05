package FactoryMethodPattern;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes type) {
        ImageReader reader = null;
        if (ImageTypes.JPG.equals(type)) reader = new JpgReader();
        else if (ImageTypes.PNG.equals(type)) reader = new PngReader();
        else if (ImageTypes.BMP.equals(type)) reader = new BmpReader();
        else throw new IllegalArgumentException();
        return reader;
    }
}
