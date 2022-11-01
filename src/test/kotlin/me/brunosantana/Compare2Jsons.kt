package me.brunosantana

import org.json.JSONObject
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.skyscreamer.jsonassert.JSONAssert
import org.skyscreamer.jsonassert.JSONCompareMode

//Examples based on:
//https://zarinfam.medium.com/how-to-compare-two-json-structures-in-java-when-the-order-of-fields-keeps-changing-f844df37e45a
class Compare2JSONs {

    @Test
     fun `compare 2 JSONs`(){
        val json1 = "{\"id\": 1, \"name\": \"Bruno\", \"posts\": [1,2,3,4]}"
        val json2 = "{\"posts\": [4,2,1,3], \"name\": \"Bruno\", \"id\": 1}"

        //Assertions.assertEquals(json1, json2) //it fails
        JSONAssert.assertEquals(json1, json2, JSONCompareMode.NON_EXTENSIBLE);
    }

    @Test
    fun `compare 2 JSONObjects`(){
        val json1 = JSONObject("{\"id\": 1, \"name\": \"Bruno\", \"posts\": [1,2,3,4]}")
        val json2 = JSONObject("{\"posts\": [4,2,1,3], \"name\": \"Bruno\", \"id\": 1}")

        //Assertions.assertEquals(json1.toString(), json2.toString()) //it fails, here is the error message:
        //Expected :{"name":"Bruno","id":1,"posts":[1,2,3,4]}
        //Actual   :{"name":"Bruno","id":1,"posts":[4,2,1,3]}

        JSONAssert.assertEquals(json1.toString(), json2.toString(), JSONCompareMode.NON_EXTENSIBLE);
    }

}