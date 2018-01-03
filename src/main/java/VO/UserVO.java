package VO;

/**
 * Created by caofanCPU on 2018/1/2.
 */
public class UserVO
{
    private String name;

    private Integer age;

    private Boolean isMarried;

    @Override
    public String toString() {
        return "UserVO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isMarried=" + isMarried +
                '}';
    }

    //    @Override
//    public String toString()
//    {
//        return "This user: \n" + "\t[name:" + this.name + "], [age:" + this.age + "], [isMarried:" + this.isMarried + "]\n";
//    }

    public UserVO()
    {

    }

    public UserVO(String name, Integer age, Boolean isMarried)
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

    public Boolean getIsMarried()
    {
        return isMarried;
    }

    public void setIsMarried(Boolean married)
    {
        isMarried = married;
    }
}
