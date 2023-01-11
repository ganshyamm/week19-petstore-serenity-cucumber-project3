package com.petstore.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PetPojo {
    private int id;
    private Map<String, ?> category;
    private String name;
    private List<?> tags;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, ?> getCategory() {
        return category;
    }

    public void setCategory(Map<String, ?> category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<?> getTags() {
        return tags;
    }

    public void setTags(List<?> tags) {
        this.tags = tags;
    }

    public List<?> getPhotourl() {
        return photourl;
    }

    public void setPhotourl(List<?> photourl) {
        this.photourl = photourl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private List<?> photourl;
    private String status;


    public static PetPojo getPetPojo(int id, String name, int cid, String cname, String photourl, int tid,
                                      String tname, String status) {
        PetPojo petPojo = new PetPojo();
        HashMap<String, Object> pet = new HashMap<String, Object>();
        pet.put("id", cid);
        pet.put("name", cname);

        List<String> photourl1 = new ArrayList<String>();
        photourl1.add(photourl);

        List<HashMap<String, Object>> petList = new ArrayList<HashMap<String, Object>>();
        petList.add(pet);

        petPojo.setId(id);
        petPojo.setCategory(pet);
        petPojo.setName(name);
        petPojo.setPhotourl(photourl1);
        petPojo.setTags(petList);
        petPojo.setStatus(status);
        return petPojo;
    }
}
