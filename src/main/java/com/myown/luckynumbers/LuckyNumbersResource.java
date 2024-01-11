package com.myown.luckynumbers;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.ws.rs.core.Response;

@Path("/gen")
public final class LuckyNumbersResource {

    @Inject
    LuckyNumbersGen luckyNumbersGen;

    @GET
    @Path("/6upto60")
    @Produces(MediaType.TEXT_PLAIN)
    public Response sixUpToSixty() {
        return Response.ok(
                luckyNumbersGen.sixSortedRandomIntegersUpToSixty().toString()
        ).build();
    }

    @GET
    @Path("/6upto60/{howManySequences}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response sixUpToSixty(@PathParam("howManySequences") final Integer howManySequences) {
        try {
            return Response.ok(
                    luckyNumbersGen.moreThanOneSixSortedRandomIntegersUpToSixty(howManySequences).toString()
            ).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/6upto60/with/{numbers}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response sixUpToSixtyWithGiven(@PathParam("numbers") final String numbers) {
        try {
            List<Integer> result = luckyNumbersGen.fillUpUntilSixSortedRandomIntegersUpToSixty(numbers);
            return Response.ok(result.toString()).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}
