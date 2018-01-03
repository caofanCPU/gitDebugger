package BasicGrammarRules;

import PO.UserPO;
import VO.UserVO;
import constants.BookingStatus;
import constants.WarehouseScaleType;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by caofanCPU on 2018/1/2.
 * String, Integer/Long, Boolean类型的转换
 *
 * 对象转换为String的结论：
 *      1.推荐(String)强转方式，理由：在代码编译期、运行期(自测代码)更容易发现更多的错误；
 *      2.(String)强转方式的特点：
 *          带转换的对象必须支持转换为String，
 *          加上obj instanceof String判断后，再强转
 *          注意null对象可强制转换为任意类型
 *      3.String.valueOf()方式的特点：
 *          使用方便，无需判断对象是否为null，
 *          但是【埋巨坑】，null对象会被转换为'null'字符串
 *      4.toString()方式的特点：
 *          使用前需要判断带转换对象是否null
 *          继承自Object默认的toString()方法，得到"类名{属性名=属性值, ...}"
 *          常用于枚举类型的使用，但定义枚举时，推荐复写toString方法，便于后续开发：取枚举名、取枚举值，项目中统一
 *
 */
public class ConvertUtils
{
    public static final Integer FIRST_ELEMENT_KEY = 1;
    public static final Integer SECOND_ELEMENT_KEY = 2;
    public static final Integer THIRD_ELEMENT_KEY = 3;
    public static final Integer FOURTH_ELEMENT_KEY = 4;
    public static final Integer FIFTH_ELEMENT_KEY = 5;

    public static void main(String[] args)
    {
//        origin2String();
//        npeFor2String();
//        testEnum();

//        cceForForceClassCastForString();
//        //just view:
//        compileFailForClassCastForString();
//        forceClassCastForNullValue();

//        valueOfForString();
//        valueOfForStringForNullValue();
/**
 * ****************************************************
 */
//        initData();

//        normalUseForToString();
//        normalUseForForceCast();
//        normalUseForValueOf();

        convert2Integer();
//        convert2Boolean();
    }

    public static void normalUseForToString()
    {
        Map<Integer, String> mappingMap = getMappingMap();
        Map<String, Object> dataMap = getHashMapData(initData(), mappingMap.get(5));
        String name = dataMap.get("name").toString();
        String age = dataMap.get("age").toString();
        String isMarried = dataMap.get("isMarried").toString();
        System.out.println("姓名：" + name + "\t类型 " + name.getClass()
                + "\n年龄：" + age + "\t类型 " + age.getClass()
                + "\n是否已婚：" + isMarried + "\t类型 " + isMarried.getClass());
    }

    public static void normalUseForForceCast()
    {
        Map<Integer, String> mappingMap = getMappingMap();
        Map<String, Object> dataMap = getHashMapData(initData(), mappingMap.get(5));
        String name = (String) dataMap.get("name");
        String age = (String) dataMap.get("age");
        String isMarried = (String) dataMap.get("isMarried");
        System.out.println("姓名：" + name + "\t类型 " + name.getClass()
                + "\n年龄：" + age + "\t类型 " + age.getClass()
                + "\n是否已婚：" + isMarried + "\t类型 " + isMarried.getClass());
    }

    public static void normalUseForValueOf()
    {
        Map<Integer, String> mappingMap = getMappingMap();
        Map<String, Object> dataMap = getHashMapData(initData(), mappingMap.get(5));
        String name = String.valueOf(dataMap.get("name"));
        String age = String.valueOf(dataMap.get("age"));
        String isMarried = String.valueOf(dataMap.get("isMarried"));
        System.out.println("姓名：" + name + "\t类型 " + name.getClass()
                + "\n年龄：" + age + "\t类型 " + age.getClass()
                + "\n是否已婚：" + isMarried + "\t类型 " + isMarried.getClass());
    }

    public static void convert2Integer()
    {
        Map<Integer, String> mappingMap = getMappingMap();
        Map<String, Object> dataMap = getHashMapData(initData(), mappingMap.get(1));
        String age = dataMap.get("age").toString();
        int ageInt = Integer.parseInt(age);
        Integer ageInt2 = Integer.valueOf(age);
        System.out.println("\n年龄：" + ageInt);
        System.out.println("\n年龄：" + ageInt2 + "\t类型 " + ageInt2.getClass());

        // mybatis： Integer(0) == ""
    }

    public static Map<String, Map<String, Object>> initData()
    {
        Map<String, Map<String, Object>> dataMap = new HashMap();
        Map<Integer, String> mappingMap = getMappingMap();
        try {
            dataMap.put(mappingMap.get(FIRST_ELEMENT_KEY), BeanMapConvertUtils.convertBean(new UserVO("小明", 18, false)));
            dataMap.put(mappingMap.get(SECOND_ELEMENT_KEY), BeanMapConvertUtils.convertBean(new UserVO(null, 28, true)));
            dataMap.put(mappingMap.get(THIRD_ELEMENT_KEY), BeanMapConvertUtils.convertBean(new UserVO("小明", null, false)));
            dataMap.put(mappingMap.get(FOURTH_ELEMENT_KEY), BeanMapConvertUtils.convertBean(new UserVO("小明", 38, null)));
            dataMap.put(mappingMap.get(FIFTH_ELEMENT_KEY), BeanMapConvertUtils.convertBean(new UserVO(null, null, null)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataMap;
    }

    public static void valueOfForStringForNullValue()
    {
        Object obj = null;
        String str = String.valueOf(obj);
        if (null == str)
        {
            System.out.println("改JDK源码耍一耍...");
        }
        if ("null".equals(str))
        {
            System.out.println("null对象经过valueOf方法装换后得到字符串'null', 而非null对象!");
        }
    }

    public static void valueOfForString()
    {
        Object obj = new Integer(1997);
//        int obj = 1997;
        String str = String.valueOf(obj);
        System.out.println("转换成功!" + str);
    }

    public static void cceForForceClassCastForString()
    {
        Object obj = new Integer(1997);
        String str = (String) obj;

        System.out.println("强转成功：" + str);
    }

    public static void npeFor2String()
    {
        UserPO userPO = null;
        System.out.println(userPO.toString());
//        Map<String, Object> dataMap = getContractById(contractId);
//        String idNo = dataMap.get(idNO).toString();
//        ...
    }

    public static void origin2String()
    {
//        UserPO userPO = new UserPO();
////        Class<?> clazz = userPO.getClass();
////        String className = clazz.getName();
////        System.out.println(clazz + "\t" + className);
////        System.out.println(userPO);
//        System.out.println(userPO.toString());
        UserVO userVO = new UserVO();
        System.out.println(userVO);
    }

    public static void convert2Boolean()
    {
        boolean flag1 = Boolean.parseBoolean("");
        Boolean flag2 = Boolean.valueOf(true);
        System.out.println("\nflag1：" + flag1);
        System.out.println("\nflag2：" + flag2 + "\t类型 " + flag2.getClass());
    }

    public static Map<String, Object> getHashMapData(Map<String, Map<String, Object>> initDataMap, String key)
    {
        Map<String, Object> dataMap = initDataMap.get(key);
        return dataMap;
    }

    public static Map<Integer, String> getMappingMap()
    {
        Map<Integer, String> mappingMap = new HashMap<>();
        mappingMap.put(FIRST_ELEMENT_KEY, "xm");
        mappingMap.put(SECOND_ELEMENT_KEY, "nameNull");
        mappingMap.put(THIRD_ELEMENT_KEY, "ageNull");
        mappingMap.put(FOURTH_ELEMENT_KEY, "marriageNull");
        mappingMap.put(FIFTH_ELEMENT_KEY, "allNull");

        return mappingMap;
    }

    public static void forceClassCastForString()
    {
        Object obj = new Integer(1997);
        if (obj instanceof String)
        {
            String str = (String) obj;
            System.out.println("强转成功：" + str);
        }
        System.out.println("强转失败!原始对象不支持强转为String类型");
    }

//    public static void compileFailForClassCastForString()
//    {
//        Integer obj = new Integer(1997);
//        String str = (String) obj;
//        System.out.println("强转成功：" + str);
//    }

    public static void forceClassCastForNullValue()
    {
        Object obj = null;
        String str = (String) obj;
        System.out.println("null对象可强转为String类型(其实是任意类型):" + str);
    }

    public static void testEnum()
    {
        WarehouseScaleType wst = WarehouseScaleType.Center;
        System.out.println("枚举名称字符串：" + wst.name() + "\t枚举名称字符串：" + wst.toString() + "\t枚举值：" + wst.getValue());

        BookingStatus bs = BookingStatus.UserBooking;
        System.out.println("枚举名称字符串：" + bs.name() + "\t枚举名称字符串：" + bs.toString() + "\t枚举值：" + bs.getValue());
    }

}
