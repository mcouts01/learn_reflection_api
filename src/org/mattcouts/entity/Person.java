package org.mattcouts.entity;

import org.mattcouts.annotation.Column;
import org.mattcouts.annotation.Id;

public class Person {
    @Id
    private int id;

    @Column
    private String firstName;

    @Column
    private String lastName;
}
