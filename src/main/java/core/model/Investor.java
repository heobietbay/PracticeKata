package core.model;

import java.util.ArrayList;
import java.util.List;

public class Investor {

    public static List<Investor> INVESTOR_LIST = new ArrayList<>();

    static {
        INVESTOR_LIST.add(createInvestor("Khoa","Tran",new Integer(1),30));
        INVESTOR_LIST.add(createInvestor("Quang","Nguyen",new Integer(2),40));
        INVESTOR_LIST.add(createInvestor("Khanh","Nguyen",3,50));
        INVESTOR_LIST.add(createInvestor("Nam","Tran",new Integer(4),60));
        INVESTOR_LIST.add(createInvestor(null,"Tran",new Integer(5),70));
    }

    public static Investor createInvestor(String firstName,
                                           String lastName,
                                           Integer investorId,
                                           Integer age)
    {
        Investor investor = new Investor();
        investor.setInvestorId(investorId);
        investor.setAge(age);
        investor.setFirstName(firstName);
        investor.setLastName(lastName);
        return investor;
    }

    /**
     * Getter.
     *
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter.
     *
     * @param firstName firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter.
     *
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter.
     *
     * @param lastName lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter.
     *
     * @return investorId
     */
    public Integer getInvestorId() {
        return investorId;
    }

    /**
     * Setter.
     *
     * @param investorId investorId
     */
    public void setInvestorId(Integer investorId) {
        this.investorId = investorId;
    }

    /**
     * Getter.
     *
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Setter.
     *
     * @param age age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Investor investor = (Investor) o;

        if (firstName != null ? !firstName.equals(investor.firstName) : investor.firstName != null) return false;
        if (!lastName.equals(investor.lastName)) return false;
        if (!investorId.equals(investor.investorId)) return false;
        return age.equals(investor.age);
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + lastName.hashCode();
        result = 31 * result + investorId.hashCode();
        result = 31 * result + age.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Investor{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", investorId=" + investorId +
                ", age=" + age +
                '}';
    }

    // can be null
    private String firstName;
    private String lastName;
    private Integer investorId;
    private Integer age;
}
