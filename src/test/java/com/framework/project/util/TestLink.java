package com.framework.project.util;

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;

public class TestLink {

 public static String APIkey="f30e7d9f97b46c29df31cfd7148dd8a4";
 public static String url="http://localhost/testlink/lib/api/xmlrpc/v1/xmlrpc.php";

 public static void reportResult(String TestProject, String TestPlan, String TestCase, String build, String Notes, String Result) throws TestLinkAPIException{
  TestLinkAPIClient api=new TestLinkAPIClient(APIkey, url);
  api.reportTestCaseResult(TestProject,TestPlan,TestCase,build,Notes,Result);
 }
}
