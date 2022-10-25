<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html> 
<body>
  <h2>Entradas del foro</h2>
  <table border="1">
    <tr bgcolor="#9acd32">
      <th style="text-align:left">Título</th>
      <th style="text-align:left">Descripción</th>
      <th style="text-align:left">Autor</th>
      <th style="text-align:left">Fecha publicación</th>
    </tr>
    <xsl:for-each select="rss/channel/item">
    <tr>
      <td><xsl:value-of select="title"/></td>
      <td><xsl:value-of select="description"/></td>
      <td><xsl:value-of select="author"/></td>
      <td><xsl:value-of select="pubDate"/></td>
    </tr>
    </xsl:for-each>
  </table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>
