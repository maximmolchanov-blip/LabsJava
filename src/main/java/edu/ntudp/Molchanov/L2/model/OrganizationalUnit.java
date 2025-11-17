package edu.ntudp.Molchanov.L2.model;

public abstract class OrganizationalUnit {
    protected String name;
    protected Human head;

    public OrganizationalUnit(String name, Human head) {
        this.name = name;
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Human getHead() {
        return head;
    }

    public void setHead(Human head) {
        this.head = head;
    }

    public abstract String getUnitType();

    @Override
    public String toString() {
        return getUnitType() + ": " + name + ", Head: " + head.getFullName();
    }
}

