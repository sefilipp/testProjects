<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
xmlns:javacourse="http://ws.cdyne.com/WeatherWS/"
        exclude-result-prefixes="javacourse">

<xsl:output method="html" indent="yes"/>

<xsl:template match="javacourse:GetCityWeatherByZIPResult">
<html>
            <head>
                <title>Данные о погоде</title>
            </head>
  <body>
  <h2> город  <xsl:value-of select="javacourse:City"/> </h2>
  <h2> температура <xsl:value-of select="javacourse:Temperature"/> градусов по фаренгейту </h2>
  </body>
 </html>
</xsl:template>

</xsl:stylesheet>
    
    <!--
    <xsl:template match="javacourse:application">
        <html>
            <head>
                <title>HTML Result</title>
            </head>
            <body>
                <xsl:variable name="age" select="javacourse:age/text()"/>
                <h1>Hello <xsl:value-of select="javacourse:name/text()"/>, your age is <xsl:value-of select="$age"/></h1>
                <xsl:variable name="permission">
                    <xsl:choose>
                        <xsl:when test="$age &gt; 18 or $age = 18">may</xsl:when>
                        <xsl:when test="$age &lt; 18">may not</xsl:when>
                    </xsl:choose>
                </xsl:variable>
                <h3>You <xsl:value-of select="$permission"/> drink C2H5OH</h3>
            </body>
        </html>
    </xsl:template>
    
    -->
   <!-- 
    <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
    <GetCityWeatherByZIPResponse xmlns="http://ws.cdyne.com/WeatherWS/">
        <GetCityWeatherByZIPResult>
            <Success>true</Success>
            <ResponseText>City Found</ResponseText>
            <State>CO</State>
            <City>Aurora</City>
            <WeatherStationCity>Aurora</WeatherStationCity>
            <WeatherID>10</WeatherID>
            <Description>Mostly Sunny</Description>
            <Temperature>59</Temperature>
            <RelativeHumidity>38</RelativeHumidity>
            <Wind>SW8</Wind>
            <Pressure>29.89R</Pressure>
            <Visibility></Visibility>
            <WindChill></WindChill>
            <Remarks></Remarks>
        </GetCityWeatherByZIPResult>
    </GetCityWeatherByZIPResponse>    
    -->