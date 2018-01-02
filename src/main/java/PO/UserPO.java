package PO;

/**
 * Created by caofanCPU on 2018/1/2.
 */
public class UserPO
{
    private String name;

    private Integer age;

    private Boolean isMarried;

//    @Override
//    public String toString()
//    {
//        return "This user: \n" + "\t[name:" + this.name + "], [age:" + this.age + "], [isMarried:" + this.isMarried + "]\n";
//    }



    public UserPO()
    {

    }

    public UserPO(String name, Integer age, Boolean isMarried)
    {
        this.name = name;
        this.age = age;
        this.isMarried = isMarried;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public Boolean getMarried()
    {
        return isMarried;
    }

    public void setMarried(Boolean married)
    {
        isMarried = married;
    }
}
