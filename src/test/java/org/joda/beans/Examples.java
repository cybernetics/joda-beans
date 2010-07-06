/*
 *  Copyright 2001-2010 Stephen Colebourne
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.joda.beans;

/**
 * Examples using Person.
 * 
 * @author Stephen Colebourne
 */
public class Examples {

    public static void main(String[] args) {
        // create the bean the hard way - could just do new Person() instead
        Person p = Person.META.createBean().beanData();
        // set surname using normal method
        p.setSurname("Colebourne");
        // query using property method
        System.out.println(p.surname().get());
        // set/get forename using property method
        p.forename().set("Stephen");
        System.out.println(p.forename().get());
        // set cars
        p.numberOfCars().set(2);
        // access all the properties
        System.out.println(p.propertyMap().values());
        System.out.println(p.metaBean().metaPropertyMap().values());
        System.out.println(p.propertyMap().flatten());
        System.out.println(p);
        // perform validation
        boolean valid =
            validateNotEmpty(p.surname()) &&
            validateNotEmpty(p.forename());
        System.out.println(valid ? "Valid" : "Not valid");
        // extensions
        p.getExtensions().set("suffix", "Jr");
        System.out.println(p.propertyMap().values());
        System.out.println(p.metaBean().metaPropertyMap().values());
        System.out.println(p.propertyMap().flatten());
        System.out.println(p);
        
        // create the bean the hard way - could just do new Address() instead
        Address a = Address.META.createBean().beanData();
        // set surname using normal method
        a.setStreet("Barnsnap Close");
        // query using property method
        System.out.println(a.street().get());
        // set/get forename using property method
        a.city().set("Horsham");
        System.out.println(a.city().get());
        // set cars
        a.number().set(22);
        // access all the properties
        System.out.println(a.propertyMap().values());
        System.out.println(a.metaBean().metaPropertyMap().values());
        System.out.println(a.propertyMap().flatten());
        System.out.println(a);
        // perform validation
        valid =
            validateNotEmpty(a.street()) &&
            validateNotEmpty(a.city());
        System.out.println(valid ? "Valid" : "Not valid");
        
//        try {
//            Mongo mongo = new Mongo("127.0.0.1");
//            System.out.println(mongo);
//            mongo.dropDatabase("BeansTest");
//            DB db = mongo.getDB("BeansTest");
//            DBCollection coll = db.createCollection("Test", new BeanMongoDBObject(p));
//            System.out.println(coll);
//            System.out.println("Docs " + coll.getCount());
//            
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
    }

    private static boolean validateNotEmpty(Property<?, String> property) {
        String str = property.get();
        return (str != null && str.length() > 0);
    }

}