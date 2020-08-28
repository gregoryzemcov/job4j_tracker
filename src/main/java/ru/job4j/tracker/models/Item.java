package ru.job4j.tracker.models;
import java.util.Objects;
/**
 * Класс "Заявка".
 * @author Gregory Zemtsov (griffondark@gmail.com).
 * @version $Id$
 * @since 05.05.2019.
 */
 public class Item {
    private String id;
    private String name;
    private String decs;
    private long time;
	public Item() { }
    public Item(String name, String decs, long time) {
        this.name = name;
        this.decs = decs;
        this.time = time;
    }
    public Item(String name) {
	    this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDecs() {
        return decs;
    }
    public void setDecs(String decs) {
        this.decs = decs;
    }
    public long getTime() {
        return time;
    }
    public void setTime(long time) {
        this.time = time;
    }
    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "Item{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", decs='" + decs + '\'' + ", time=" + time + '}';
        //super.toString();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return time == item.time && Objects.equals(id, item.id) && Objects.equals(name, item.name) && Objects.equals(decs, item.decs);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, decs, time);
    }
}