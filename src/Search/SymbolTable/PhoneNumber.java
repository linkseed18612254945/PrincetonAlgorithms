package Search.SymbolTable;

/**
 * Created by 51694 on 2017/7/5.
 */
public class PhoneNumber
{
    private final int area;
    private final int exch;
    private final int ext;

    PhoneNumber(int area, int exch, int ext)
    {
        this.area = area;
        this.exch = exch;
        this.ext = ext;
    }

    @Override
    public boolean equals(Object other)
    {
        if (this == other) return true;
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;
        PhoneNumber that = (PhoneNumber) other;
        return (this.area == that.area) && (this.exch == that.exch) && (this.ext == that.ext);
    }

}
