<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:template match="/">
		<table border="1">
			<tr>
				<th>이름</th>
				<th>이메일</th>
				<th>연락처</th>
			</tr>
			<xsl:for-each select="namecard/person">
			<tr>
				<td><xsl:value-of select="name" /></td>
				<td><xsl:value-of select="email" /></td>
				<td><xsl:value-of select="phone" /></td>
				</tr>
			</xsl:for-each>
		</table>
	</xsl:template>
</xsl:stylesheet>