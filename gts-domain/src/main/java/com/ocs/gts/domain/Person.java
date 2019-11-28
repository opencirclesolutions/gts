package com.ocs.gts.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ocs.dynamo.domain.AbstractEntity;
import com.ocs.dynamo.domain.model.VisibilityType;
import com.ocs.dynamo.domain.model.annotation.Attribute;
import com.ocs.dynamo.domain.model.annotation.Model;

@Entity
@Table(name = "person")
@Model(displayProperty = "nickName")
public class Person extends AbstractEntity<Integer> {

    private static final long serialVersionUID = -3436199710873943375L;

    @Id
    @SequenceGenerator(name = "person_id_gen", sequenceName = "person_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_id_gen")
    private Integer id;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @NotNull
    @Size(max = 255)
    @Column(name = "first_name")
    @Attribute(searchable = true)
    private String firstName;

    @NotNull
    @Size(max = 255)
    @Column(name = "last_name")
    @Attribute(searchable = true)
    private String lastName;

    @NotNull
    @Size(max = 255)
    @Column(name = "nickname")
    private String nickName;

    //@NotNull
    @JoinColumn(name = "organization")
    @ManyToOne(fetch = FetchType.LAZY)
    @Attribute(navigable = true, visibleInGrid = VisibilityType.SHOW)
    private Organization organization;

    @Attribute(week = true)
    private LocalDate born;

    @Attribute(week = true)
    private LocalDate died;

    @ElementCollection
    @CollectionTable(name = "person_lucky_numbers")
    @Column(name = "lucky_number")
    @Attribute(complexEditable = true)
    private Set<Integer> luckyNumbers = new HashSet<>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public LocalDate getBorn() {
        return born;
    }

    public void setBorn(LocalDate born) {
        this.born = born;
    }

    public LocalDate getDied() {
        return died;
    }

    public void setDied(LocalDate died) {
        this.died = died;
    }

    public Set<Integer> getLuckyNumbers() {
        return luckyNumbers;
    }

    public void setLuckyNumbers(Set<Integer> luckyNumbers) {
        this.luckyNumbers = luckyNumbers;
    }
}
