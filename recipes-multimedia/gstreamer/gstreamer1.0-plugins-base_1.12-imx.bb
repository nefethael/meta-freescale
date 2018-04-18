require gstreamer1.0-plugins-base.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=c54ce9345727175ff66d17b67ff51f58 \
                    file://COPYING.LIB;md5=6762ed442b3822387a51c92d928ead0d \
                    file://common/coverage/coverage-report.pl;beginline=2;endline=17;md5=a4e1830fce078028c8f0974161272607"

GST1.0-PLUGINS-BASE_SRC ?= "gitsm://source.codeaurora.org/external/imx/gst-plugins-base.git;protocol=https"
SRCBRANCH = "MM_04.03.04_1801_L4.9.51_MX8M_GA"
SRC_URI = " \
    ${GST1.0-PLUGINS-BASE_SRC};branch=${SRCBRANCH} \
    file://make-gio_unix_2_0-dependency-configurable.patch \
    file://0001-introspection.m4-prefix-pkgconfig-paths-with-PKG_CON.patch \
"

SRCREV = "3a615cab2e22e133048157ba107dc6c24e08c7e0"

S = "${WORKDIR}/git"

# This remove "--exclude=autopoint" option from autoreconf argument to avoid
# configure.ac:30: error: required file './ABOUT-NLS' not found
EXTRA_AUTORECONF = ""

PACKAGE_ARCH = "${MACHINE_SOCARCH}"

COMPATIBLE_MACHINE = "(mx6|mx7|mx8)"
