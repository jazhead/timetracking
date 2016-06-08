package de.jazhead.timetracking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @Author jazhead
 */
@Entity
@Table(name = "project")
public class Project
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
    private List<SubProject> subProjects;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<SubProject> getSubProjects()
    {
        return subProjects;
    }

    public void setSubProjects(List<SubProject> subProjects)
    {
        this.subProjects = subProjects;
    }
}
