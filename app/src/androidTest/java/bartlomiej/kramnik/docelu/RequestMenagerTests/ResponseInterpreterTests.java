package bartlomiej.kramnik.docelu.RequestMenagerTests;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import bartlomiej.kramnik.docelu.Model.DataModels.Route;
import bartlomiej.kramnik.docelu.Model.RouteSearch.ResponseInterpreter.JsonResponseInterpreter;

/**
 * Tests of JsonInterpreter
 */

@RunWith(AndroidJUnit4.class)
public class ResponseInterpreterTests {

    private JsonResponseInterpreter responseInterpreter = new JsonResponseInterpreter();

    @Test
    public void interpretingTets1(){
        try{
            Route route  = responseInterpreter.getRoute(testString1);
            Assert.assertEquals(1, route.getLinesCount());
        }
        catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }

    }

    @Test
    public void interpretingTets2(){
        try{
            Route route  = responseInterpreter.getRoute(testString2);
            Assert.assertEquals(3, route.getLinesCount());
        }
        catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }

    }

    @Test
    public void interpretingTestNull(){
        try{
            Route route  = responseInterpreter.getRoute(null);
        Assert.assertNull(route);
        }
        catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void interpretingEmptyTest(){
        try{
            Route route  = responseInterpreter.getRoute("");
            Assert.assertNull(route);
        }
        catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }

    private final String testString3 = "";

    private final String testString2 = "{\n" +
            "    \"geocoded_waypoints\": [\n" +
            "        {\n" +
            "            \"geocoder_status\": \"OK\",\n" +
            "            \"partial_match\": true,\n" +
            "            \"place_id\": \"ChIJJb-ZMP3DD0cR4mC5Curu0mg\",\n" +
            "            \"types\": [\n" +
            "                \"street_address\"\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"geocoder_status\": \"OK\",\n" +
            "            \"place_id\": \"ChIJN4s1SMnpD0cRovXBrvxjVA8\",\n" +
            "            \"types\": [\n" +
            "                \"establishment\",\n" +
            "                \"point_of_interest\",\n" +
            "                \"premise\"\n" +
            "            ]\n" +
            "        }\n" +
            "    ],\n" +
            "    \"routes\": [\n" +
            "        {\n" +
            "            \"bounds\": {\n" +
            "                \"northeast\": {\n" +
            "                    \"lat\": 51.12650319999999,\n" +
            "                    \"lng\": 17.0572081\n" +
            "                },\n" +
            "                \"southwest\": {\n" +
            "                    \"lat\": 51.047176,\n" +
            "                    \"lng\": 16.9587857\n" +
            "                }\n" +
            "            },\n" +
            "            \"copyrights\": \"Map data ©2017 Google\",\n" +
            "            \"legs\": [\n" +
            "                {\n" +
            "                    \"arrival_time\": {\n" +
            "                        \"text\": \"9:16pm\",\n" +
            "                        \"time_zone\": \"Europe/Warsaw\",\n" +
            "                        \"value\": 1514319384\n" +
            "                    },\n" +
            "                    \"departure_time\": {\n" +
            "                        \"text\": \"7:57pm\",\n" +
            "                        \"time_zone\": \"Europe/Warsaw\",\n" +
            "                        \"value\": 1514314624\n" +
            "                    },\n" +
            "                    \"distance\": {\n" +
            "                        \"text\": \"12.5 km\",\n" +
            "                        \"value\": 12469\n" +
            "                    },\n" +
            "                    \"duration\": {\n" +
            "                        \"text\": \"1 hour 19 mins\",\n" +
            "                        \"value\": 4760\n" +
            "                    },\n" +
            "                    \"end_address\": \"Stefana Jaracza 37, 50-305 Wrocław, Poland\",\n" +
            "                    \"end_location\": {\n" +
            "                        \"lat\": 51.1250818,\n" +
            "                        \"lng\": 17.0572081\n" +
            "                    },\n" +
            "                    \"start_address\": \"Czekoladowa 14, Bielany Wrocławskie, Poland\",\n" +
            "                    \"start_location\": {\n" +
            "                        \"lat\": 51.0471796,\n" +
            "                        \"lng\": 16.9587857\n" +
            "                    },\n" +
            "                    \"steps\": [\n" +
            "                        {\n" +
            "                            \"distance\": {\n" +
            "                                \"text\": \"1.6 km\",\n" +
            "                                \"value\": 1635\n" +
            "                            },\n" +
            "                            \"duration\": {\n" +
            "                                \"text\": \"21 mins\",\n" +
            "                                \"value\": 1254\n" +
            "                            },\n" +
            "                            \"end_location\": {\n" +
            "                                \"lat\": 51.0567143,\n" +
            "                                \"lng\": 16.9713184\n" +
            "                            },\n" +
            "                            \"html_instructions\": \"Walk to Połabian\",\n" +
            "                            \"polyline\": {\n" +
            "                                \"points\": \"{cqvHmgofB?M?k@?YUA]Au@C@s@?I@a@@m@@m@@k@@m@@m@?M?Q?c@@c@?K@a@@m@@k@@m@@m@@k@?m@Bm@?]?C?C?A?ECIKc@Oo@K_@qBIKCIA_CIcAEcAEBuA[A[?i@Gq@Eo@Cm@Ce@?e@@E?EAE?CCCEEGEGCKEIEMEGEIGGECEEGCGEEAEAG?I?G@G@EBIBGBK?E?C?EACAEAEEu@oACCUWeAgBkAgBsC}DIGGIcBiCIKeAyBCECKaCaD}A_C{@mADK\"\n" +
            "                            },\n" +
            "                            \"start_location\": {\n" +
            "                                \"lat\": 51.0471796,\n" +
            "                                \"lng\": 16.9587857\n" +
            "                            },\n" +
            "                            \"steps\": [\n" +
            "                                {\n" +
            "                                    \"distance\": {\n" +
            "                                        \"text\": \"30 m\",\n" +
            "                                        \"value\": 30\n" +
            "                                    },\n" +
            "                                    \"duration\": {\n" +
            "                                        \"text\": \"1 min\",\n" +
            "                                        \"value\": 23\n" +
            "                                    },\n" +
            "                                    \"end_location\": {\n" +
            "                                        \"lat\": 51.047176,\n" +
            "                                        \"lng\": 16.9592084\n" +
            "                                    },\n" +
            "                                    \"html_instructions\": \"Head <b>east</b> on <b>Czekoladowa</b>/<b>DK35</b>\",\n" +
            "                                    \"polyline\": {\n" +
            "                                        \"points\": \"{cqvHmgofB?M?k@?Y\"\n" +
            "                                    },\n" +
            "                                    \"start_location\": {\n" +
            "                                        \"lat\": 51.0471796,\n" +
            "                                        \"lng\": 16.9587857\n" +
            "                                    },\n" +
            "                                    \"travel_mode\": \"WALKING\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"distance\": {\n" +
            "                                        \"text\": \"60 m\",\n" +
            "                                        \"value\": 60\n" +
            "                                    },\n" +
            "                                    \"duration\": {\n" +
            "                                        \"text\": \"1 min\",\n" +
            "                                        \"value\": 62\n" +
            "                                    },\n" +
            "                                    \"end_location\": {\n" +
            "                                        \"lat\": 51.0477122,\n" +
            "                                        \"lng\": 16.9592535\n" +
            "                                    },\n" +
            "                                    \"html_instructions\": \"Turn <b>left</b>\",\n" +
            "                                    \"maneuver\": \"turn-left\",\n" +
            "                                    \"polyline\": {\n" +
            "                                        \"points\": \"{cqvHajofBUA]Au@C\"\n" +
            "                                    },\n" +
            "                                    \"start_location\": {\n" +
            "                                        \"lat\": 51.047176,\n" +
            "                                        \"lng\": 16.9592084\n" +
            "                                    },\n" +
            "                                    \"travel_mode\": \"WALKING\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"distance\": {\n" +
            "                                        \"text\": \"0.3 km\",\n" +
            "                                        \"value\": 343\n" +
            "                                    },\n" +
            "                                    \"duration\": {\n" +
            "                                        \"text\": \"4 mins\",\n" +
            "                                        \"value\": 269\n" +
            "                                    },\n" +
            "                                    \"end_location\": {\n" +
            "                                        \"lat\": 51.0477666,\n" +
            "                                        \"lng\": 16.9640654\n" +
            "                                    },\n" +
            "                                    \"html_instructions\": \"Turn <b>right</b>\",\n" +
            "                                    \"maneuver\": \"turn-right\",\n" +
            "                                    \"polyline\": {\n" +
            "                                        \"points\": \"egqvHijofB@s@?I@a@@m@@m@@k@@m@@m@?M?Q?c@@c@?K@a@@m@@k@@m@@m@@k@?m@Bm@?]?C?C?A?ECIKc@Oo@K_@\"\n" +
            "                                    },\n" +
            "                                    \"start_location\": {\n" +
            "                                        \"lat\": 51.0477122,\n" +
            "                                        \"lng\": 16.9592535\n" +
            "                                    },\n" +
            "                                    \"travel_mode\": \"WALKING\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"distance\": {\n" +
            "                                        \"text\": \"0.2 km\",\n" +
            "                                        \"value\": 224\n" +
            "                                    },\n" +
            "                                    \"duration\": {\n" +
            "                                        \"text\": \"3 mins\",\n" +
            "                                        \"value\": 166\n" +
            "                                    },\n" +
            "                                    \"end_location\": {\n" +
            "                                        \"lat\": 51.0497732,\n" +
            "                                        \"lng\": 16.9642559\n" +
            "                                    },\n" +
            "                                    \"html_instructions\": \"Turn <b>left</b>\",\n" +
            "                                    \"maneuver\": \"turn-left\",\n" +
            "                                    \"polyline\": {\n" +
            "                                        \"points\": \"qgqvHmhpfBqBIKCIA_CIcAEcAE\"\n" +
            "                                    },\n" +
            "                                    \"start_location\": {\n" +
            "                                        \"lat\": 51.0477666,\n" +
            "                                        \"lng\": 16.9640654\n" +
            "                                    },\n" +
            "                                    \"travel_mode\": \"WALKING\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"distance\": {\n" +
            "                                        \"text\": \"30 m\",\n" +
            "                                        \"value\": 30\n" +
            "                                    },\n" +
            "                                    \"duration\": {\n" +
            "                                        \"text\": \"1 min\",\n" +
            "                                        \"value\": 21\n" +
            "                                    },\n" +
            "                                    \"end_location\": {\n" +
            "                                        \"lat\": 51.0497546,\n" +
            "                                        \"lng\": 16.9646904\n" +
            "                                    },\n" +
            "                                    \"html_instructions\": \"Turn <b>right</b> toward <b>Czekoladowa</b>\",\n" +
            "                                    \"maneuver\": \"turn-right\",\n" +
            "                                    \"polyline\": {\n" +
            "                                        \"points\": \"atqvHsipfBBuA\"\n" +
            "                                    },\n" +
            "                                    \"start_location\": {\n" +
            "                                        \"lat\": 51.0497732,\n" +
            "                                        \"lng\": 16.9642559\n" +
            "                                    },\n" +
            "                                    \"travel_mode\": \"WALKING\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"distance\": {\n" +
            "                                        \"text\": \"0.2 km\",\n" +
            "                                        \"value\": 201\n" +
            "                                    },\n" +
            "                                    \"duration\": {\n" +
            "                                        \"text\": \"2 mins\",\n" +
            "                                        \"value\": 149\n" +
            "                                    },\n" +
            "                                    \"end_location\": {\n" +
            "                                        \"lat\": 51.0515335,\n" +
            "                                        \"lng\": 16.9649439\n" +
            "                                    },\n" +
            "                                    \"html_instructions\": \"Turn <b>left</b> toward <b>Czekoladowa</b>\",\n" +
            "                                    \"maneuver\": \"turn-left\",\n" +
            "                                    \"polyline\": {\n" +
            "                                        \"points\": \"}sqvHilpfB[A[?i@Gq@Eo@Cm@Ce@?e@@E?EAE?CCCEEGEG\"\n" +
            "                                    },\n" +
            "                                    \"start_location\": {\n" +
            "                                        \"lat\": 51.0497546,\n" +
            "                                        \"lng\": 16.9646904\n" +
            "                                    },\n" +
            "                                    \"travel_mode\": \"WALKING\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"distance\": {\n" +
            "                                        \"text\": \"0.4 km\",\n" +
            "                                        \"value\": 385\n" +
            "                                    },\n" +
            "                                    \"duration\": {\n" +
            "                                        \"text\": \"5 mins\",\n" +
            "                                        \"value\": 275\n" +
            "                                    },\n" +
            "                                    \"end_location\": {\n" +
            "                                        \"lat\": 51.05429059999999,\n" +
            "                                        \"lng\": 16.9678822\n" +
            "                                    },\n" +
            "                                    \"html_instructions\": \"At the roundabout, take the <b>3rd</b> exit onto <b>Czekoladowa</b>\",\n" +
            "                                    \"maneuver\": \"roundabout-right\",\n" +
            "                                    \"polyline\": {\n" +
            "                                        \"points\": \"a_rvH{mpfBCKEIEMEGEIGGECEEGCGEEAEAG?I?G@G@EBIBGBK?E?C?EACAEAEEu@oACCUWeAgBkAgBsC}D\"\n" +
            "                                    },\n" +
            "                                    \"start_location\": {\n" +
            "                                        \"lat\": 51.0515335,\n" +
            "                                        \"lng\": 16.9649439\n" +
            "                                    },\n" +
            "                                    \"travel_mode\": \"WALKING\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"distance\": {\n" +
            "                                        \"text\": \"0.4 km\",\n" +
            "                                        \"value\": 362\n" +
            "                                    },\n" +
            "                                    \"duration\": {\n" +
            "                                        \"text\": \"5 mins\",\n" +
            "                                        \"value\": 289\n" +
            "                                    },\n" +
            "                                    \"end_location\": {\n" +
            "                                        \"lat\": 51.0567143,\n" +
            "                                        \"lng\": 16.9713184\n" +
            "                                    },\n" +
            "                                    \"html_instructions\": \"Slight <b>left</b> to stay on <b>Czekoladowa</b><div style=\\\"font-size:0.9em\\\">Destination will be on the right</div>\",\n" +
            "                                    \"maneuver\": \"turn-slight-left\",\n" +
            "                                    \"polyline\": {\n" +
            "                                        \"points\": \"iprvHg`qfBIGGIcBiCIKeAyBCECKaCaD}A_C{@mADK\"\n" +
            "                                    },\n" +
            "                                    \"start_location\": {\n" +
            "                                        \"lat\": 51.05429059999999,\n" +
            "                                        \"lng\": 16.9678822\n" +
            "                                    },\n" +
            "                                    \"travel_mode\": \"WALKING\"\n" +
            "                                }\n" +
            "                            ],\n" +
            "                            \"travel_mode\": \"WALKING\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"distance\": {\n" +
            "                                \"text\": \"2.7 km\",\n" +
            "                                \"value\": 2713\n" +
            "                            },\n" +
            "                            \"duration\": {\n" +
            "                                \"text\": \"8 mins\",\n" +
            "                                \"value\": 480\n" +
            "                            },\n" +
            "                            \"end_location\": {\n" +
            "                                \"lat\": 51.0713285,\n" +
            "                                \"lng\": 17.0000094\n" +
            "                            },\n" +
            "                            \"html_instructions\": \"Bus towards Brochów\",\n" +
            "                            \"polyline\": {\n" +
            "                                \"points\": \"m_svHwuqfBwSuTsM_I}HsRNiZqH_U}HcWaO_e@_JqO\"\n" +
            "                            },\n" +
            "                            \"start_location\": {\n" +
            "                                \"lat\": 51.0567143,\n" +
            "                                \"lng\": 16.9713184\n" +
            "                            },\n" +
            "                            \"transit_details\": {\n" +
            "                                \"arrival_stop\": {\n" +
            "                                    \"location\": {\n" +
            "                                        \"lat\": 51.0713285,\n" +
            "                                        \"lng\": 17.0000094\n" +
            "                                    },\n" +
            "                                    \"name\": \"Zimowa\"\n" +
            "                                },\n" +
            "                                \"arrival_time\": {\n" +
            "                                    \"text\": \"8:26pm\",\n" +
            "                                    \"time_zone\": \"Europe/Warsaw\",\n" +
            "                                    \"value\": 1514316360\n" +
            "                                },\n" +
            "                                \"departure_stop\": {\n" +
            "                                    \"location\": {\n" +
            "                                        \"lat\": 51.0567143,\n" +
            "                                        \"lng\": 16.9713184\n" +
            "                                    },\n" +
            "                                    \"name\": \"Połabian\"\n" +
            "                                },\n" +
            "                                \"departure_time\": {\n" +
            "                                    \"text\": \"8:18pm\",\n" +
            "                                    \"time_zone\": \"Europe/Warsaw\",\n" +
            "                                    \"value\": 1514315880\n" +
            "                                },\n" +
            "                                \"headsign\": \"Brochów\",\n" +
            "                                \"line\": {\n" +
            "                                    \"agencies\": [\n" +
            "                                        {\n" +
            "                                            \"name\": \"MPK Autobusy\",\n" +
            "                                            \"phone\": \"011 48 71 321 72 71\",\n" +
            "                                            \"url\": \"http://www.mpk.wroc.pl/\"\n" +
            "                                        }\n" +
            "                                    ],\n" +
            "                                    \"short_name\": \"133\",\n" +
            "                                    \"vehicle\": {\n" +
            "                                        \"icon\": \"//maps.gstatic.com/mapfiles/transit/iw2/6/bus2.png\",\n" +
            "                                        \"name\": \"Bus\",\n" +
            "                                        \"type\": \"BUS\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                \"num_stops\": 8\n" +
            "                            },\n" +
            "                            \"travel_mode\": \"TRANSIT\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"distance\": {\n" +
            "                                \"text\": \"1 m\",\n" +
            "                                \"value\": 0\n" +
            "                            },\n" +
            "                            \"duration\": {\n" +
            "                                \"text\": \"1 min\",\n" +
            "                                \"value\": 0\n" +
            "                            },\n" +
            "                            \"end_location\": {\n" +
            "                                \"lat\": 51.0713285,\n" +
            "                                \"lng\": 17.0000094\n" +
            "                            },\n" +
            "                            \"html_instructions\": \"Walk to Zimowa\",\n" +
            "                            \"polyline\": {\n" +
            "                                \"points\": \"yzuvHaiwfB\"\n" +
            "                            },\n" +
            "                            \"start_location\": {\n" +
            "                                \"lat\": 51.0713285,\n" +
            "                                \"lng\": 17.0000094\n" +
            "                            },\n" +
            "                            \"steps\": [\n" +
            "                                {\n" +
            "                                    \"distance\": {\n" +
            "                                        \"text\": \"1 m\",\n" +
            "                                        \"value\": 0\n" +
            "                                    },\n" +
            "                                    \"duration\": {\n" +
            "                                        \"text\": \"1 min\",\n" +
            "                                        \"value\": 0\n" +
            "                                    },\n" +
            "                                    \"end_location\": {\n" +
            "                                        \"lat\": 51.0713285,\n" +
            "                                        \"lng\": 17.0000094\n" +
            "                                    },\n" +
            "                                    \"polyline\": {\n" +
            "                                        \"points\": \"yzuvHaiwfB\"\n" +
            "                                    },\n" +
            "                                    \"start_location\": {\n" +
            "                                        \"lat\": 51.0713285,\n" +
            "                                        \"lng\": 17.0000094\n" +
            "                                    },\n" +
            "                                    \"travel_mode\": \"WALKING\"\n" +
            "                                }\n" +
            "                            ],\n" +
            "                            \"travel_mode\": \"WALKING\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"distance\": {\n" +
            "                                \"text\": \"4.1 km\",\n" +
            "                                \"value\": 4086\n" +
            "                            },\n" +
            "                            \"duration\": {\n" +
            "                                \"text\": \"11 mins\",\n" +
            "                                \"value\": 660\n" +
            "                            },\n" +
            "                            \"end_location\": {\n" +
            "                                \"lat\": 51.10203910000001,\n" +
            "                                \"lng\": 17.0298365\n" +
            "                            },\n" +
            "                            \"html_instructions\": \"Bus towards Osiedle Sobieskiego\",\n" +
            "                            \"polyline\": {\n" +
            "                                \"points\": \"yzuvHaiwfBqZwn@sZgDsh@sZaZa^acAwiA\"\n" +
            "                            },\n" +
            "                            \"start_location\": {\n" +
            "                                \"lat\": 51.0713285,\n" +
            "                                \"lng\": 17.0000094\n" +
            "                            },\n" +
            "                            \"transit_details\": {\n" +
            "                                \"arrival_stop\": {\n" +
            "                                    \"location\": {\n" +
            "                                        \"lat\": 51.10203910000001,\n" +
            "                                        \"lng\": 17.0298365\n" +
            "                                    },\n" +
            "                                    \"name\": \"Arkady (Capitol)\"\n" +
            "                                },\n" +
            "                                \"arrival_time\": {\n" +
            "                                    \"text\": \"8:53pm\",\n" +
            "                                    \"time_zone\": \"Europe/Warsaw\",\n" +
            "                                    \"value\": 1514317980\n" +
            "                                },\n" +
            "                                \"departure_stop\": {\n" +
            "                                    \"location\": {\n" +
            "                                        \"lat\": 51.0713285,\n" +
            "                                        \"lng\": 17.0000094\n" +
            "                                    },\n" +
            "                                    \"name\": \"Zimowa\"\n" +
            "                                },\n" +
            "                                \"departure_time\": {\n" +
            "                                    \"text\": \"8:42pm\",\n" +
            "                                    \"time_zone\": \"Europe/Warsaw\",\n" +
            "                                    \"value\": 1514317320\n" +
            "                                },\n" +
            "                                \"headsign\": \"Osiedle Sobieskiego\",\n" +
            "                                \"line\": {\n" +
            "                                    \"agencies\": [\n" +
            "                                        {\n" +
            "                                            \"name\": \"MPK Autobusy\",\n" +
            "                                            \"phone\": \"011 48 71 321 72 71\",\n" +
            "                                            \"url\": \"http://www.mpk.wroc.pl/\"\n" +
            "                                        }\n" +
            "                                    ],\n" +
            "                                    \"short_name\": \"D\",\n" +
            "                                    \"vehicle\": {\n" +
            "                                        \"icon\": \"//maps.gstatic.com/mapfiles/transit/iw2/6/bus2.png\",\n" +
            "                                        \"name\": \"Bus\",\n" +
            "                                        \"type\": \"BUS\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                \"num_stops\": 5\n" +
            "                            },\n" +
            "                            \"travel_mode\": \"TRANSIT\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"distance\": {\n" +
            "                                \"text\": \"1 m\",\n" +
            "                                \"value\": 0\n" +
            "                            },\n" +
            "                            \"duration\": {\n" +
            "                                \"text\": \"1 min\",\n" +
            "                                \"value\": 0\n" +
            "                            },\n" +
            "                            \"end_location\": {\n" +
            "                                \"lat\": 51.10203910000001,\n" +
            "                                \"lng\": 17.0298365\n" +
            "                            },\n" +
            "                            \"html_instructions\": \"Walk to Arkady (Capitol)\",\n" +
            "                            \"polyline\": {\n" +
            "                                \"points\": \"wz{vHoc}fB\"\n" +
            "                            },\n" +
            "                            \"start_location\": {\n" +
            "                                \"lat\": 51.10203910000001,\n" +
            "                                \"lng\": 17.0298365\n" +
            "                            },\n" +
            "                            \"steps\": [\n" +
            "                                {\n" +
            "                                    \"distance\": {\n" +
            "                                        \"text\": \"1 m\",\n" +
            "                                        \"value\": 0\n" +
            "                                    },\n" +
            "                                    \"duration\": {\n" +
            "                                        \"text\": \"1 min\",\n" +
            "                                        \"value\": 0\n" +
            "                                    },\n" +
            "                                    \"end_location\": {\n" +
            "                                        \"lat\": 51.10203910000001,\n" +
            "                                        \"lng\": 17.0298365\n" +
            "                                    },\n" +
            "                                    \"polyline\": {\n" +
            "                                        \"points\": \"wz{vHoc}fB\"\n" +
            "                                    },\n" +
            "                                    \"start_location\": {\n" +
            "                                        \"lat\": 51.10203910000001,\n" +
            "                                        \"lng\": 17.0298365\n" +
            "                                    },\n" +
            "                                    \"travel_mode\": \"WALKING\"\n" +
            "                                }\n" +
            "                            ],\n" +
            "                            \"travel_mode\": \"WALKING\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"distance\": {\n" +
            "                                \"text\": \"3.8 km\",\n" +
            "                                \"value\": 3763\n" +
            "                            },\n" +
            "                            \"duration\": {\n" +
            "                                \"text\": \"11 mins\",\n" +
            "                                \"value\": 660\n" +
            "                            },\n" +
            "                            \"end_location\": {\n" +
            "                                \"lat\": 51.1264885,\n" +
            "                                \"lng\": 17.0548761\n" +
            "                            },\n" +
            "                            \"html_instructions\": \"Bus towards KOSZAROWA (Szpital)\",\n" +
            "                            \"polyline\": {\n" +
            "                                \"points\": \"wz{vHoc}fBpDs~@m\\\\wSu[w_@mV{LoQeCgb@{GaVmK\"\n" +
            "                            },\n" +
            "                            \"start_location\": {\n" +
            "                                \"lat\": 51.10203910000001,\n" +
            "                                \"lng\": 17.0298365\n" +
            "                            },\n" +
            "                            \"transit_details\": {\n" +
            "                                \"arrival_stop\": {\n" +
            "                                    \"location\": {\n" +
            "                                        \"lat\": 51.1264885,\n" +
            "                                        \"lng\": 17.0548761\n" +
            "                                    },\n" +
            "                                    \"name\": \"Damrota\"\n" +
            "                                },\n" +
            "                                \"arrival_time\": {\n" +
            "                                    \"text\": \"9:13pm\",\n" +
            "                                    \"time_zone\": \"Europe/Warsaw\",\n" +
            "                                    \"value\": 1514319180\n" +
            "                                },\n" +
            "                                \"departure_stop\": {\n" +
            "                                    \"location\": {\n" +
            "                                        \"lat\": 51.10203910000001,\n" +
            "                                        \"lng\": 17.0298365\n" +
            "                                    },\n" +
            "                                    \"name\": \"Arkady (Capitol)\"\n" +
            "                                },\n" +
            "                                \"departure_time\": {\n" +
            "                                    \"text\": \"9:02pm\",\n" +
            "                                    \"time_zone\": \"Europe/Warsaw\",\n" +
            "                                    \"value\": 1514318520\n" +
            "                                },\n" +
            "                                \"headsign\": \"KOSZAROWA (Szpital)\",\n" +
            "                                \"line\": {\n" +
            "                                    \"agencies\": [\n" +
            "                                        {\n" +
            "                                            \"name\": \"MPK Autobusy\",\n" +
            "                                            \"phone\": \"011 48 71 321 72 71\",\n" +
            "                                            \"url\": \"http://www.mpk.wroc.pl/\"\n" +
            "                                        }\n" +
            "                                    ],\n" +
            "                                    \"short_name\": \"A\",\n" +
            "                                    \"vehicle\": {\n" +
            "                                        \"icon\": \"//maps.gstatic.com/mapfiles/transit/iw2/6/bus2.png\",\n" +
            "                                        \"name\": \"Bus\",\n" +
            "                                        \"type\": \"BUS\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                \"num_stops\": 7\n" +
            "                            },\n" +
            "                            \"travel_mode\": \"TRANSIT\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"distance\": {\n" +
            "                                \"text\": \"0.3 km\",\n" +
            "                                \"value\": 272\n" +
            "                            },\n" +
            "                            \"duration\": {\n" +
            "                                \"text\": \"3 mins\",\n" +
            "                                \"value\": 204\n" +
            "                            },\n" +
            "                            \"end_location\": {\n" +
            "                                \"lat\": 51.1250818,\n" +
            "                                \"lng\": 17.0572081\n" +
            "                            },\n" +
            "                            \"html_instructions\": \"Walk to Stefana Jaracza 37, 50-305 Wrocław, Poland\",\n" +
            "                            \"polyline\": {\n" +
            "                                \"points\": \"qs`wH_`bgBAXZFb@LdCaGHQxAmDJWMUKQ\"\n" +
            "                            },\n" +
            "                            \"start_location\": {\n" +
            "                                \"lat\": 51.1264885,\n" +
            "                                \"lng\": 17.0548761\n" +
            "                            },\n" +
            "                            \"steps\": [\n" +
            "                                {\n" +
            "                                    \"distance\": {\n" +
            "                                        \"text\": \"37 m\",\n" +
            "                                        \"value\": 37\n" +
            "                                    },\n" +
            "                                    \"duration\": {\n" +
            "                                        \"text\": \"1 min\",\n" +
            "                                        \"value\": 26\n" +
            "                                    },\n" +
            "                                    \"end_location\": {\n" +
            "                                        \"lat\": 51.1261804,\n" +
            "                                        \"lng\": 17.0546352\n" +
            "                                    },\n" +
            "                                    \"html_instructions\": \"Head <b>south</b> on <b>Wyszyńskiego</b> toward <b>Damrota</b>\",\n" +
            "                                    \"polyline\": {\n" +
            "                                        \"points\": \"qs`wH_`bgBAXZFb@L\"\n" +
            "                                    },\n" +
            "                                    \"start_location\": {\n" +
            "                                        \"lat\": 51.1264885,\n" +
            "                                        \"lng\": 17.0548761\n" +
            "                                    },\n" +
            "                                    \"travel_mode\": \"WALKING\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"distance\": {\n" +
            "                                        \"text\": \"0.2 km\",\n" +
            "                                        \"value\": 215\n" +
            "                                    },\n" +
            "                                    \"duration\": {\n" +
            "                                        \"text\": \"3 mins\",\n" +
            "                                        \"value\": 162\n" +
            "                                    },\n" +
            "                                    \"end_location\": {\n" +
            "                                        \"lat\": 51.1249525,\n" +
            "                                        \"lng\": 17.0570142\n" +
            "                                    },\n" +
            "                                    \"html_instructions\": \"Turn <b>left</b> onto <b>Damrota</b>\",\n" +
            "                                    \"maneuver\": \"turn-left\",\n" +
            "                                    \"polyline\": {\n" +
            "                                        \"points\": \"sq`wHo~agBdCaGHQxAmDJW\"\n" +
            "                                    },\n" +
            "                                    \"start_location\": {\n" +
            "                                        \"lat\": 51.1261804,\n" +
            "                                        \"lng\": 17.0546352\n" +
            "                                    },\n" +
            "                                    \"travel_mode\": \"WALKING\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"distance\": {\n" +
            "                                        \"text\": \"20 m\",\n" +
            "                                        \"value\": 20\n" +
            "                                    },\n" +
            "                                    \"duration\": {\n" +
            "                                        \"text\": \"1 min\",\n" +
            "                                        \"value\": 16\n" +
            "                                    },\n" +
            "                                    \"end_location\": {\n" +
            "                                        \"lat\": 51.1250818,\n" +
            "                                        \"lng\": 17.0572081\n" +
            "                                    },\n" +
            "                                    \"html_instructions\": \"Turn <b>left</b> onto <b>Stefana Jaracza</b><div style=\\\"font-size:0.9em\\\">Destination will be on the right</div>\",\n" +
            "                                    \"maneuver\": \"turn-left\",\n" +
            "                                    \"polyline\": {\n" +
            "                                        \"points\": \"}i`wHimbgBMUKQ\"\n" +
            "                                    },\n" +
            "                                    \"start_location\": {\n" +
            "                                        \"lat\": 51.1249525,\n" +
            "                                        \"lng\": 17.0570142\n" +
            "                                    },\n" +
            "                                    \"travel_mode\": \"WALKING\"\n" +
            "                                }\n" +
            "                            ],\n" +
            "                            \"travel_mode\": \"WALKING\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"traffic_speed_entry\": [],\n" +
            "                    \"via_waypoint\": []\n" +
            "                }\n" +
            "            ],\n" +
            "            \"overview_polyline\": {\n" +
            "                \"points\": \"{cqvHmgofB?y@?YUAsAE@}@FiDB{BJkHDuDk@}B}BMiCKgCKBuA[A[?i@GaBIsACk@@KAGIKOIUYg@[S]C_@JSBI?UKy@sA{A_C_FeHQQmBuCiA_CeCmDyCmEDKwSuTsM_I}HsRNiZqH_U}HcWaO_e@_JqOqZwn@sZgDsh@sZaZa^acAwiApDs~@m\\\\wSu[w_@mV{LoQeCgb@{GaVmKAX~@TtFyMYg@\"\n" +
            "            },\n" +
            "            \"summary\": \"\",\n" +
            "            \"warnings\": [\n" +
            "                \"Walking directions are in beta.    Use caution – This route may be missing sidewalks or pedestrian paths.\"\n" +
            "            ],\n" +
            "            \"waypoint_order\": []\n" +
            "        }\n" +
            "    ],\n" +
            "    \"status\": \"OK\"\n" +
            "}";

    private final String testString1 = "{\n" +
            "    \"geocoded_waypoints\": [\n" +
            "        {\n" +
            "            \"geocoder_status\": \"OK\",\n" +
            "            \"place_id\": \"ChIJsX84rg7qD0cRbdGJB9nC90U\",\n" +
            "            \"types\": [\n" +
            "                \"street_address\"\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"geocoder_status\": \"OK\",\n" +
            "            \"place_id\": \"ChIJN4s1SMnpD0cRovXBrvxjVA8\",\n" +
            "            \"types\": [\n" +
            "                \"establishment\",\n" +
            "                \"point_of_interest\",\n" +
            "                \"premise\"\n" +
            "            ]\n" +
            "        }\n" +
            "    ],\n" +
            "    \"routes\": [\n" +
            "        {\n" +
            "            \"bounds\": {\n" +
            "                \"northeast\": {\n" +
            "                    \"lat\": 51.12945149999999,\n" +
            "                    \"lng\": 17.0572081\n" +
            "                },\n" +
            "                \"southwest\": {\n" +
            "                    \"lat\": 51.1166326,\n" +
            "                    \"lng\": 16.982565\n" +
            "                }\n" +
            "            },\n" +
            "            \"copyrights\": \"Map data ©2017 Google\",\n" +
            "            \"legs\": [\n" +
            "                {\n" +
            "                    \"arrival_time\": {\n" +
            "                        \"text\": \"7:47pm\",\n" +
            "                        \"time_zone\": \"Europe/Warsaw\",\n" +
            "                        \"value\": 1514314044\n" +
            "                    },\n" +
            "                    \"departure_time\": {\n" +
            "                        \"text\": \"7:20pm\",\n" +
            "                        \"time_zone\": \"Europe/Warsaw\",\n" +
            "                        \"value\": 1514312419\n" +
            "                    },\n" +
            "                    \"distance\": {\n" +
            "                        \"text\": \"7.0 km\",\n" +
            "                        \"value\": 7010\n" +
            "                    },\n" +
            "                    \"duration\": {\n" +
            "                        \"text\": \"27 mins\",\n" +
            "                        \"value\": 1625\n" +
            "                    },\n" +
            "                    \"end_address\": \"Stefana Jaracza 37, 50-305 Wrocław, Poland\",\n" +
            "                    \"end_location\": {\n" +
            "                        \"lat\": 51.1250818,\n" +
            "                        \"lng\": 17.0572081\n" +
            "                    },\n" +
            "                    \"start_address\": \"Legnicka 144, Wrocław, Poland\",\n" +
            "                    \"start_location\": {\n" +
            "                        \"lat\": 51.12554189999999,\n" +
            "                        \"lng\": 16.982565\n" +
            "                    },\n" +
            "                    \"steps\": [\n" +
            "                        {\n" +
            "                            \"distance\": {\n" +
            "                                \"text\": \"71 m\",\n" +
            "                                \"value\": 71\n" +
            "                            },\n" +
            "                            \"duration\": {\n" +
            "                                \"text\": \"1 min\",\n" +
            "                                \"value\": 52\n" +
            "                            },\n" +
            "                            \"end_location\": {\n" +
            "                                \"lat\": 51.12527499999999,\n" +
            "                                \"lng\": 16.9835144\n" +
            "                            },\n" +
            "                            \"html_instructions\": \"Walk to Kwiska\",\n" +
            "                            \"polyline\": {\n" +
            "                                \"points\": \"sm`wH_|sfBfAiDQS\"\n" +
            "                            },\n" +
            "                            \"start_location\": {\n" +
            "                                \"lat\": 51.12554189999999,\n" +
            "                                \"lng\": 16.982565\n" +
            "                            },\n" +
            "                            \"steps\": [\n" +
            "                                {\n" +
            "                                    \"distance\": {\n" +
            "                                        \"text\": \"71 m\",\n" +
            "                                        \"value\": 71\n" +
            "                                    },\n" +
            "                                    \"duration\": {\n" +
            "                                        \"text\": \"1 min\",\n" +
            "                                        \"value\": 52\n" +
            "                                    },\n" +
            "                                    \"end_location\": {\n" +
            "                                        \"lat\": 51.12527499999999,\n" +
            "                                        \"lng\": 16.9835144\n" +
            "                                    },\n" +
            "                                    \"html_instructions\": \"Head <b>southeast</b> on <b>Legnicka</b>\",\n" +
            "                                    \"polyline\": {\n" +
            "                                        \"points\": \"sm`wH_|sfBfAiDQS\"\n" +
            "                                    },\n" +
            "                                    \"start_location\": {\n" +
            "                                        \"lat\": 51.12554189999999,\n" +
            "                                        \"lng\": 16.982565\n" +
            "                                    },\n" +
            "                                    \"travel_mode\": \"WALKING\"\n" +
            "                                }\n" +
            "                            ],\n" +
            "                            \"travel_mode\": \"WALKING\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"distance\": {\n" +
            "                                \"text\": \"6.7 km\",\n" +
            "                                \"value\": 6667\n" +
            "                            },\n" +
            "                            \"duration\": {\n" +
            "                                \"text\": \"22 mins\",\n" +
            "                                \"value\": 1320\n" +
            "                            },\n" +
            "                            \"end_location\": {\n" +
            "                                \"lat\": 51.1264885,\n" +
            "                                \"lng\": 17.0548761\n" +
            "                            },\n" +
            "                            \"html_instructions\": \"Bus towards Zakrzów\",\n" +
            "                            \"polyline\": {\n" +
            "                                \"points\": \"}k`wH}atfBcYqRrHuWtJce@\\\\oe@fMmq@p\\\\uW`Miv@}Fyk@|DwSEgx@c@sq@gb@{GaVmK\"\n" +
            "                            },\n" +
            "                            \"start_location\": {\n" +
            "                                \"lat\": 51.12527499999999,\n" +
            "                                \"lng\": 16.9835144\n" +
            "                            },\n" +
            "                            \"transit_details\": {\n" +
            "                                \"arrival_stop\": {\n" +
            "                                    \"location\": {\n" +
            "                                        \"lat\": 51.1264885,\n" +
            "                                        \"lng\": 17.0548761\n" +
            "                                    },\n" +
            "                                    \"name\": \"Damrota\"\n" +
            "                                },\n" +
            "                                \"arrival_time\": {\n" +
            "                                    \"text\": \"7:44pm\",\n" +
            "                                    \"time_zone\": \"Europe/Warsaw\",\n" +
            "                                    \"value\": 1514313840\n" +
            "                                },\n" +
            "                                \"departure_stop\": {\n" +
            "                                    \"location\": {\n" +
            "                                        \"lat\": 51.12527499999999,\n" +
            "                                        \"lng\": 16.9835144\n" +
            "                                    },\n" +
            "                                    \"name\": \"Kwiska\"\n" +
            "                                },\n" +
            "                                \"departure_time\": {\n" +
            "                                    \"text\": \"7:22pm\",\n" +
            "                                    \"time_zone\": \"Europe/Warsaw\",\n" +
            "                                    \"value\": 1514312520\n" +
            "                                },\n" +
            "                                \"headsign\": \"Zakrzów\",\n" +
            "                                \"line\": {\n" +
            "                                    \"agencies\": [\n" +
            "                                        {\n" +
            "                                            \"name\": \"MPK Autobusy\",\n" +
            "                                            \"phone\": \"011 48 71 321 72 71\",\n" +
            "                                            \"url\": \"http://www.mpk.wroc.pl/\"\n" +
            "                                        }\n" +
            "                                    ],\n" +
            "                                    \"short_name\": \"128\",\n" +
            "                                    \"vehicle\": {\n" +
            "                                        \"icon\": \"//maps.gstatic.com/mapfiles/transit/iw2/6/bus2.png\",\n" +
            "                                        \"name\": \"Bus\",\n" +
            "                                        \"type\": \"BUS\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                \"num_stops\": 13\n" +
            "                            },\n" +
            "                            \"travel_mode\": \"TRANSIT\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"distance\": {\n" +
            "                                \"text\": \"0.3 km\",\n" +
            "                                \"value\": 272\n" +
            "                            },\n" +
            "                            \"duration\": {\n" +
            "                                \"text\": \"3 mins\",\n" +
            "                                \"value\": 204\n" +
            "                            },\n" +
            "                            \"end_location\": {\n" +
            "                                \"lat\": 51.1250818,\n" +
            "                                \"lng\": 17.0572081\n" +
            "                            },\n" +
            "                            \"html_instructions\": \"Walk to Stefana Jaracza 37, 50-305 Wrocław, Poland\",\n" +
            "                            \"polyline\": {\n" +
            "                                \"points\": \"qs`wH_`bgBAXZFb@LdCaGHQxAmDJWMUKQ\"\n" +
            "                            },\n" +
            "                            \"start_location\": {\n" +
            "                                \"lat\": 51.1264885,\n" +
            "                                \"lng\": 17.0548761\n" +
            "                            },\n" +
            "                            \"steps\": [\n" +
            "                                {\n" +
            "                                    \"distance\": {\n" +
            "                                        \"text\": \"37 m\",\n" +
            "                                        \"value\": 37\n" +
            "                                    },\n" +
            "                                    \"duration\": {\n" +
            "                                        \"text\": \"1 min\",\n" +
            "                                        \"value\": 26\n" +
            "                                    },\n" +
            "                                    \"end_location\": {\n" +
            "                                        \"lat\": 51.1261804,\n" +
            "                                        \"lng\": 17.0546352\n" +
            "                                    },\n" +
            "                                    \"html_instructions\": \"Head <b>south</b> on <b>Wyszyńskiego</b> toward <b>Damrota</b>\",\n" +
            "                                    \"polyline\": {\n" +
            "                                        \"points\": \"qs`wH_`bgBAXZFb@L\"\n" +
            "                                    },\n" +
            "                                    \"start_location\": {\n" +
            "                                        \"lat\": 51.1264885,\n" +
            "                                        \"lng\": 17.0548761\n" +
            "                                    },\n" +
            "                                    \"travel_mode\": \"WALKING\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"distance\": {\n" +
            "                                        \"text\": \"0.2 km\",\n" +
            "                                        \"value\": 215\n" +
            "                                    },\n" +
            "                                    \"duration\": {\n" +
            "                                        \"text\": \"3 mins\",\n" +
            "                                        \"value\": 162\n" +
            "                                    },\n" +
            "                                    \"end_location\": {\n" +
            "                                        \"lat\": 51.1249525,\n" +
            "                                        \"lng\": 17.0570142\n" +
            "                                    },\n" +
            "                                    \"html_instructions\": \"Turn <b>left</b> onto <b>Damrota</b>\",\n" +
            "                                    \"maneuver\": \"turn-left\",\n" +
            "                                    \"polyline\": {\n" +
            "                                        \"points\": \"sq`wHo~agBdCaGHQxAmDJW\"\n" +
            "                                    },\n" +
            "                                    \"start_location\": {\n" +
            "                                        \"lat\": 51.1261804,\n" +
            "                                        \"lng\": 17.0546352\n" +
            "                                    },\n" +
            "                                    \"travel_mode\": \"WALKING\"\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"distance\": {\n" +
            "                                        \"text\": \"20 m\",\n" +
            "                                        \"value\": 20\n" +
            "                                    },\n" +
            "                                    \"duration\": {\n" +
            "                                        \"text\": \"1 min\",\n" +
            "                                        \"value\": 16\n" +
            "                                    },\n" +
            "                                    \"end_location\": {\n" +
            "                                        \"lat\": 51.1250818,\n" +
            "                                        \"lng\": 17.0572081\n" +
            "                                    },\n" +
            "                                    \"html_instructions\": \"Turn <b>left</b> onto <b>Stefana Jaracza</b><div style=\\\"font-size:0.9em\\\">Destination will be on the right</div>\",\n" +
            "                                    \"maneuver\": \"turn-left\",\n" +
            "                                    \"polyline\": {\n" +
            "                                        \"points\": \"}i`wHimbgBMUKQ\"\n" +
            "                                    },\n" +
            "                                    \"start_location\": {\n" +
            "                                        \"lat\": 51.1249525,\n" +
            "                                        \"lng\": 17.0570142\n" +
            "                                    },\n" +
            "                                    \"travel_mode\": \"WALKING\"\n" +
            "                                }\n" +
            "                            ],\n" +
            "                            \"travel_mode\": \"WALKING\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"traffic_speed_entry\": [],\n" +
            "                    \"via_waypoint\": []\n" +
            "                }\n" +
            "            ],\n" +
            "            \"overview_polyline\": {\n" +
            "                \"points\": \"sm`wH_|sfBfAiDQScYqRrHuWtJce@\\\\oe@fMmq@p\\\\uW`Miv@}Fyk@|DwSEgx@c@sq@gb@{GaVmKAX~@TnCsGdBeEYg@\"\n" +
            "            },\n" +
            "            \"summary\": \"\",\n" +
            "            \"warnings\": [\n" +
            "                \"Walking directions are in beta.    Use caution – This route may be missing sidewalks or pedestrian paths.\"\n" +
            "            ],\n" +
            "            \"waypoint_order\": []\n" +
            "        }\n" +
            "    ],\n" +
            "    \"status\": \"OK\"\n" +
            "}";

}

