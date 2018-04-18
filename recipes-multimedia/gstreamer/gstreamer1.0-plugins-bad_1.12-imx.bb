require gstreamer1.0-plugins-bad.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=73a5855a8119deb017f5f13cf327095d \
                    file://COPYING.LIB;md5=21682e4e8fea52413fd26c60acb907e5 "

GST1.0-PLUGINS-BAD_SRC ?= "gitsm://source.codeaurora.org/external/imx/gst-plugins-bad.git;protocol=https"
SRCBRANCH = "MM_04.03.04_1801_L4.9.51_MX8M_GA"
SRC_URI = " \
    ${GST1.0-PLUGINS-BAD_SRC};branch=${SRCBRANCH} \
    file://configure-allow-to-disable-libssh2.patch \
    file://fix-maybe-uninitialized-warnings-when-compiling-with-Os.patch \
    file://avoid-including-sys-poll.h-directly.patch \
    file://ensure-valid-sentinels-for-gst_structure_get-etc.patch \
    file://0001-gstreamer-gl.pc.in-don-t-append-GL_CFLAGS-to-CFLAGS.patch \
    file://0009-glimagesink-Downrank-to-marginal.patch \
    file://0001-introspection.m4-prefix-pkgconfig-paths-with-PKG_CON.patch \
    file://link-with-libvchostif.patch \
    file://0001-vkdisplay-Use-ifdef-for-platform-specific-defines.patch \
    file://0002-vulkan-Use-the-generated-version-of-vkconfig.h.patch \
"
SRCREV = "a755b8a4570265a041ec0867629c6bade338b4d9"

S = "${WORKDIR}/git"

# This remove "--exclude=autopoint" option from autoreconf argument to avoid
# configure.ac:30: error: required file './ABOUT-NLS' not found
EXTRA_AUTORECONF = ""

# Disable introspection to fix [GstGL-1.0.gir] Error
EXTRA_OECONF_append = " --disable-introspection"

# include fragment shaders
FILES_${PN}-opengl += "/usr/share/*.fs"

# Fix libgstbadion-1.0.so.0 which is under built directory cannot be found
do_compile_prepend () {
    export GIR_EXTRA_LIBS_PATH="${B}/gst-libs/gst/ion/.libs"
}

PACKAGE_ARCH = "${MACHINE_SOCARCH}"

COMPATIBLE_MACHINE = "(mx6|mx7|mx8)"
