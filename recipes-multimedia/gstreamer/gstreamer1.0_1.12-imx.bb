require gstreamer1.0.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6762ed442b3822387a51c92d928ead0d \
                    file://gst/gst.h;beginline=1;endline=21;md5=e059138481205ee2c6fc1c079c016d0d"

GST1.0_SRC ?= "gitsm://source.codeaurora.org/external/imx/gstreamer.git;protocol=https"
SRCBRANCH = "imx-1.12.x"
SRC_URI = "${GST1.0_SRC};branch=${SRCBRANCH}"

SRCREV = "cca1ebf223bd423ed5fc21031014ee1f3ce497a1"

S = "${WORKDIR}/git"

CVE_PRODUCT = "gstreamer"

# This remove "--exclude=autopoint" option from autoreconf argument to avoid
# configure.ac:30: error: required file './ABOUT-NLS' not found
EXTRA_AUTORECONF = ""

### We default to OE-Core ones
DEFAULT_PREFERRENCE = "-1"

PACKAGE_ARCH = "${MACHINE_SOCARCH}"

COMPATIBLE_MACHINE = "(mx6|mx7|mx8)"
