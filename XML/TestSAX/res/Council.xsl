
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <body>
  <h2>Uva Provincial Council</h2>
  <p>
  <font color="#872d2d" size="6">
  	Minister:
  </font>
  
  
  <xsl:for-each select="council">
    	<xsl:value-of select="minister"/>
  </xsl:for-each>
  </p>
  
  <br></br>
    
  <table border="1">
    <tr bgcolor="#9acd32">
      <th>Name</th>
      <th>Size</th>
      <th>Population</th>
      <th>Elevation</th>
      <th>Type</th>
    </tr>
      
    <xsl:for-each select="council/district">
    <tr>
      <td><xsl:value-of select="@name"/></td>
      <td><xsl:value-of select="size"/></td>
      <td><xsl:value-of select="population"/></td>
      <td><xsl:value-of select="elevation"/></td>
      <td><xsl:value-of select="type"/></td>
    </tr>
    
    </xsl:for-each>
  </table>
  <br></br>
    <table border="1">
    <tr bgcolor="#9acd32">
      <th>Ministry Name</th>
      <th>SubMinister</th>
      <th>Secretary</th>
      <th>Priority</th>
      <th>status</th>
    </tr>
      
    <xsl:for-each select="council/ministry">
    <tr>
      <td><xsl:value-of select="@name"/></td>
      <td><xsl:value-of select="subminister"/></td>
      <td><xsl:value-of select="secretary"/></td>
      <td><xsl:value-of select="priority"/></td>
      <td><xsl:value-of select="status"/></td>
    </tr>
    
    </xsl:for-each>
  </table>
  
  </body>
  </html>
</xsl:template>

</xsl:stylesheet>