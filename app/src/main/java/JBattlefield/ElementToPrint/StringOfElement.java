package JBattlefield.ElementToPrint;

/**
 * This functional Interface deals with providing
 * a method by taking a type parameter, which allows
 * us to offer a rapresentation in the
 * form of a String of an element we are considering.
 * This allows you to avoid duplicate code and carry out
 * individual responsabilities within the classes. When a
 * class will implement this interface, it will have to
 * provide a rapresentation of object under consideration, so
 * that each object has its own way of rapresenting its
 * data in String form.
 * @param <T> the tipe parameter.
 */
@FunctionalInterface
public interface StringOfElement <T>{

    /**
     * This method allows us to offer a rapresentation
     * in the form of a String of the element we are considering.
     * @param element the element we are considering.
     * @return the rapresentation of data for this element.
     */
    String printOfElement(T element);
}
