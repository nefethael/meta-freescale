DESCRIPTION = "Tool used to send commands to hardware via NXP's UTP protocol"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8264535c0c4e9c6c335635c4026a8022"

DEPENDS = "sg3-utils"

SRCREV = "7fe590fef812561cceb08aaa10b64e9bac8f542f"
SRC_URI = " \
    git://github.com/ixonos/utp_com;protocol=https \
    file://0001-Fix-Makefile-for-crosscompilation.patch \
"

PV = "1.0+git${SRCPV}"

S = "${WORKDIR}/git"

do_configure[noexec] = "1"

do_compile () {
	oe_runmake
}

do_install () {
    install -d -m 0755 ${D}${bindir}
    install -m 0755 ${S}/utp_com ${D}${bindir}/utp_com
}

BBCLASSEXTEND = "native nativesdk"
