package de.jazhead.timetracking.dao.impl;

import de.jazhead.timetracking.dao.AbstractDao;
import de.jazhead.timetracking.dao.ProjectDao;
import de.jazhead.timetracking.model.Project;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author jazhead
 */
@Repository
public class DefaultProjectDao extends AbstractDao implements ProjectDao
{
    @Override
    public List<Project> findAllProjects()
    {
        return getCurrentSession().createCriteria(Project.class).list();
    }

    @Override
    public int saveProject(String text)
    {
        Project project = new Project();
        project.setName(text);

        return (int) getCurrentSession().save(project);
    }

    @Override
    public Project findProject(int id)
    {
        return (Project) getCurrentSession().createCriteria(Project.class).add(Restrictions.eq("id", id)).uniqueResult();
    }
}


