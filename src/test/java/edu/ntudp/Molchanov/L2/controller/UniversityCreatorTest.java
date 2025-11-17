package edu.ntudp.Molchanov.L2.controller;

import com.google.gson.Gson;
import edu.ntudp.Molchanov.L2.controller.UniversityCreator;
import edu.ntudp.Molchanov.L2.model.University;
import edu.ntudp.Molchanov.L3.JsonManager;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UniversityCreatorTest {

    @Test
    public void testUniversityJsonSerialization() {
        UniversityCreator universityCreator = new UniversityCreator();
        University oldUniversity = universityCreator.createTypicalUniversity();
        JsonManager jsonManager = new JsonManager(new Gson());
        String filePath = "OldUniversity.json";
        jsonManager.writeUniversityToJson(oldUniversity, filePath);
        University newUniversity = jsonManager.readUniversityFromJson(filePath);
        assertEquals(newUniversity, oldUniversity);

    }
}