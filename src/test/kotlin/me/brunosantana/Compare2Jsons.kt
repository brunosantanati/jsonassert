package me.brunosantana

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.skyscreamer.jsonassert.JSONAssert
import org.skyscreamer.jsonassert.JSONCompareMode

class Compare2JSONs {

    @Test
     fun `compare 2 JSONs`(){
        val json1 = "{\"id\": 1, \"name\": \"Bruno\", \"posts\": [1,2,3,4]}"
        val json2 = "{\"posts\": [4,2,1,3], \"name\": \"Bruno\", \"id\": 1}"

        //Assertions.assertEquals(json1, json2) //it fails
        JSONAssert.assertEquals(json1, json2, JSONCompareMode.NON_EXTENSIBLE);
    }

}