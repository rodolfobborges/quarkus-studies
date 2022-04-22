package com.myown.luckynumbers;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/gen")
public class LuckyNumbersResource {


    @Inject
    LuckyNumbersGen luckyNumbersGen;

    @GET
    @Path("/6upto60")
    @Produces(MediaType.TEXT_PLAIN)
    public String sixUpToSixty() {
        return luckyNumbersGen.sixSortedRandomIntegersTillSixty().toString();
    }
}
