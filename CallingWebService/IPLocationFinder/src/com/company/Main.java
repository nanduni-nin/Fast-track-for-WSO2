package com.company;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import net.webservicex.GeoIPServiceSoap;

import javax.rmi.CORBA.Stub;

public class Main {

    public static void main(String[] args) {
	    if(args.length != 1){
            System.out.println("You need to pass in one IP address");
        }
        else{
            String ipAddress = args[0];
            //Create an object of serive name class of SEI
            GeoIPService ipService = new GeoIPService();
            GeoIPServiceSoap geoIPServiceSoap = ipService.getGeoIPServiceSoap();
            GeoIP geoIP = geoIPServiceSoap.getGeoIP(ipAddress);
            System.out.println(geoIP.getCountryName());
        }
    }
}
