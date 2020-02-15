package com.softserve.firstdemo.service;

import com.softserve.firstdemo.dao.CityDao;
import com.softserve.firstdemo.dao.CountryDao;
import com.softserve.firstdemo.dao.ProjectDao;
import com.softserve.firstdemo.entity.City;
import com.softserve.firstdemo.entity.Country;
import com.softserve.firstdemo.entity.Project;

import java.sql.Date;
import java.util.List;

//import org.apache.log4j.Logger;

public class ProjectService {
    //    private static Logger logger = Logger.getLogger(ProjectService.class);
    private ProjectDao projectDao = new ProjectDao();
    private CountryDao countryDao = new CountryDao();
    private CityDao cityDao = new CityDao();

    public void addProject(String name, String description, Date startDate, int duration,
                           String urlImage, String country, String city) {

        Project project = new Project();

        if (name != null && !name.equalsIgnoreCase("")) {
            project.setName(name);
        }


        if (description != null && !description.equalsIgnoreCase("")) {
            project.setDescription(description);
        }

        if (startDate != null) {
            project.setStartDate(startDate);
        }

        if (duration != 0) {
            project.setDuration(duration);
        }

        if (urlImage != null && !urlImage.equalsIgnoreCase("")) {
            project.setUrlImage(urlImage);
        }

        if (country != null && !country.equalsIgnoreCase("")) {
            Country country1 = countryDao.readCountryByName(country);
            if (country1 != null) {
                project.setCountry(country1);
            } else {
                country1 = new Country();
                country1.setName(country);
                countryDao.create(country1);
                country1 = countryDao.readCountryByName(country);
                project.setCountry(country1);
            }

        }

        if (city != null && !city.equalsIgnoreCase("")) {
            City city1 = cityDao.readCityByName(city);
            if (city1 != null) {
                project.setCity(city1);
            } else {
                city1 = new City();
                city1.setName(city);
                cityDao.create(city1);
                city1 = cityDao.readCityByName(city);
                project.setCity(city1);
            }
        }
        projectDao.create(project);
    }

    public Project findById(int id) {
        return projectDao.readById(id);
    }

    public List<Project> findAllProjects() {
        return projectDao.readAll();
    }

    public void editProject(int id, String name, String description, Date startDate, int duration,
                            String urlImage, String country, String city) {

        Project project = projectDao.readById(id);

        if (name != null && !name.equalsIgnoreCase("")) {
            project.setName(name);
        }

        if (description != null && !description.equalsIgnoreCase("")) {
            project.setDescription(description);
        }

        if (startDate != null) {
            project.setStartDate(startDate);
        }

        if (duration != 0) {
            project.setDuration(duration);
        }

        if (urlImage != null && !urlImage.equalsIgnoreCase("")) {
            project.setUrlImage(urlImage);
        }

        if (country != null && !country.equalsIgnoreCase("")) {
            Country country1 = countryDao.readCountryByName(country);
            if (country1 != null) {
                project.setCountry(country1);
            } else {
                country1 = new Country();
                country1.setName(country);
                countryDao.create(country1);
                country1 = countryDao.readCountryByName(country);
                project.setCountry(country1);
            }

        }

        if (city != null && !city.equalsIgnoreCase("")) {
            City city1 = cityDao.readCityByName(city);
            if (city1 != null) {
                project.setCity(city1);
            } else {
                city1 = new City();
                city1.setName(city);
                cityDao.create(city1);
                city1 = cityDao.readCityByName(city);
                project.setCity(city1);
            }
        }

        projectDao.update(project);

    }

    public void deleteProject(int id) {
        if (id != 0) {
            projectDao.delete(id);
        }
    }
}
