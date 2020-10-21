package com.danielcirilo.recyclerviewcountries;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class CountryParser {
    ArrayList<Country> listaPaises;
    private InputStream  file;
    private  Country [] countries;
    Country country = null;
    public CountryParser(InputStream file) {
        this.file  = file;


    }
    public Country[] parseCountriesFromXml()  {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            NodeList nList = document.getElementsByTagName("country");
            countries= new Country[nList.getLength()];
            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    //Obtengo los atributos del elemento pais
                    String countryCode = eElement.getAttribute("countryCode");
                    String countryName = eElement.getAttribute("countryName");
                    String countryCapita = eElement.getAttribute("capital");
                    float countryPopulation = Float.parseFloat(eElement.getAttribute("population"));

                    countries[i] = new Country(countryCode,countryName,countryPopulation,countryCapita);
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return countries;
    }
}
