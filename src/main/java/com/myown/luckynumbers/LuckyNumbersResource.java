package com.myown.luckynumbers;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/gen")
public class LuckyNumbersResource {


    @Inject
    LuckyNumbersGen luckyNumbersGen;

    @GET
    @Path("/6upto60")
    @Produces(MediaType.TEXT_PLAIN)
    public String sixUpToSixty() {
        return luckyNumbersGen.sixSortedRandomIntegersUpToSixty().toString();
    }

    @GET
    @Path("/6upto60/{howMany}")
    @Produces(MediaType.TEXT_PLAIN)
    public String sixUpToSixty(@PathParam("howMany") Integer howMany) {
        return luckyNumbersGen.moreThanOneSixSortedRandomIntegersUpToSixty(howMany).toString();
    }
}
