package com.myown.luckynumbers;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/gen")
public final class LuckyNumbersResource {

    @Inject
    LuckyNumbersGen luckyNumbersGen;

    @GET
    @Path("/6upto60")
    @Produces(MediaType.TEXT_PLAIN)
    public String sixUpToSixty() {
        return luckyNumbersGen.sixSortedRandomIntegersUpToSixty().toString();
    }

    @GET
    @Path("/6upto60/{howMany}/times")
    @Produces(MediaType.TEXT_PLAIN)
    public String sixUpToSixty(@PathParam("howMany") final Integer howMany) {
        return luckyNumbersGen.moreThanOneSixSortedRandomIntegersUpToSixty(howMany).toString();
    }

    @GET
    @Path("/6upto60/with/{numbers}")
    @Produces(MediaType.TEXT_PLAIN)
    public String sixUpToSixty(@PathParam("numbers") final String numbers) {
        return luckyNumbersGen.fillUpUntilSixSortedRandomIntegersUpToSixty(numbers).toString();
    }
}
